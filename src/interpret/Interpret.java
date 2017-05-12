package interpret;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Interpret {
	//private Class<?> classObj;
	//private Object instance = null;

	private HashMap<String, Object> instances = new HashMap<String, Object>();
	private HashMap<String, Class<?>> classes = new HashMap<String, Class<?>>();

	public Interpret() {

	}

	public String[] getFirldLists(String className) throws ClassNotFoundException {

		 Class<?> classObj = Class.forName(className);
		//System.out.println(className);
		Member[] members = classObj.getDeclaredFields();

		String result[] = new String[members.length];

		for (int i = 0; i < members.length; i++) {
			result[i] = members[i].getName();
			//System.out.println(result[i]);
		}
		return result;
	}


	public String[] getFirldListsOfInstance(String name) throws ClassNotFoundException {

		Class<?>  classObj = getClass(name);
		//System.out.println(name);
		//classObj.setAccessible(true);
		Member[] members = classObj.getDeclaredFields();

		String result[] = new String[members.length];

		for (int i = 0; i < members.length; i++) {
			result[i] = members[i].getName();
		//	System.out.println(result[i]);
		}
		return result;
	}

	public String[] getConstructorStrs(String className) throws ClassNotFoundException {
		Class<?>  classObj =Class.forName(className);
		Constructor<?>[] cs = classObj.getConstructors();
		String result[] = new String[cs.length];

		for (int i = 0; i < cs.length; i++) {
			result[i] = cs[i].toString();

		}
		return result;
	}
	public Constructor<?>[] getConstructorLists(String className) throws ClassNotFoundException {
		Class<?>  classObj =Class.forName(className);
		return  classObj.getConstructors();
	}

	public Method[] getMethodLists(String className) throws ClassNotFoundException {

		 Class<?>  classObj = Class.forName(className);
		//System.out.println(className);
		return classObj.getMethods();
	}

	public Method[] getMethodListsOfInstance(String name) throws ClassNotFoundException {

		 Class<?> classObj = getClass(name);
		//System.out.println(classObj);
		return classObj.getMethods();
	}

	public String convertArgmentsStrOf(Method method) {
		String ret = "void";
		Class<?>[] argmentClasses = method.getParameterTypes();
		for (Class<?> c : argmentClasses) {
			if (ret.equals("void")) {
				ret = c.getName();
			} else {
				ret += ", " + c.getName();
			}
		}
		return ret;
	}

	public boolean exits(String instanceName) {
		return instances.containsKey(instanceName);
	}

	public void createInstance(String className, String objName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		if (instances.containsKey(objName)) {
			throw new InstantiationException();
		}

		Class<?> classObj = Class.forName(className);
		Object instance = classObj.newInstance();
		instances.put(objName, instance);
		classes.put(objName, classObj);
	}
	public String[] getInstances() {

		LinkedList<String> list = new LinkedList<String>();
		for(Map.Entry<String, Object> set : instances.entrySet()) {
			if(!set.getValue().getClass().isArray()) {
				list.add(set.getKey());
			}
		}
		return list.toArray(new String[0]);
	}

	public Field getField(String instanceName, String fieldName) throws NoSuchFieldException, SecurityException {
		Field field = getClass(instanceName).getDeclaredField(fieldName);
		return field;
	}

	private Class<?> getClass(String instanceName) {
		if(instanceName.contains("[")) {
			//System.out.println(instanceName);
			instanceName = instanceName.substring(0, instanceName.indexOf('['));
			instanceName += "[]";
			//System.out.println(instanceName);
		}
		return classes.get(instanceName);
	}

	public Object getInstance(String name) {
		if(name.contains("[")) {
			String indexStr = name.substring(name.indexOf('[') + 1, name.indexOf(']'));
			int index = Integer.parseInt(indexStr);
			//System.out.println(indexStr);
			String arrayStr = name.substring(0,name.indexOf('['))  + "[]";
			Object array = instances.get(arrayStr);
			//System.out.println(arrayStr );
			return Array.get(array, index);
		}
		return instances.get(name);
	}

	public void setPrimitive(String InstanceName, Field field, String valueName)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		switch (field.getType().toString()) {
		case "int":
			field.setInt(getInstance(InstanceName), Integer.parseInt(valueName));
			break;

		case "char":
			field.setChar(getInstance(InstanceName), valueName.charAt(0));
			break;

		case "boolean":
			field.setBoolean(getInstance(InstanceName), Boolean.parseBoolean(valueName));
			break;

		case "byte":
			field.setByte(getInstance(InstanceName), Byte.parseByte(valueName));
			break;

		case "double":
			field.setDouble(getInstance(InstanceName), Double.parseDouble(valueName));
			break;

		case "float":
			field.setFloat(getInstance(InstanceName), Float.parseFloat(valueName));
			break;

		case "long":
			field.setLong(getInstance(InstanceName), Long.parseLong(valueName));
			break;

		case "short":
			field.setShort(getInstance(InstanceName), Short.parseShort(valueName));
			break;

		case "String":
		case "java.lang.String":
			field.set(InstanceName, valueName);
			break;

		default:
			field.set(getInstance(InstanceName), valueName);
			break;
		}
	}

	public Object conevertStrToObjcet(String valueName,String typeName ) {

		if(typeName.isEmpty()) {
			return null;
		}
		switch (typeName) {
		case "int":
			return Integer.parseInt(valueName);

		case "char":
			return valueName.charAt(0);

		case "boolean":
			return  Boolean.parseBoolean(valueName);

		case "byte":
			return Byte.parseByte(valueName);

		case "double":
			return Double.parseDouble(valueName);

		case "float":
			return Float.parseFloat(valueName);

		case "long":
			return Long.parseLong(valueName);

		case "short":
			return Short.parseShort(valueName);

		case "String":
		case "java.lang.String":
			return valueName;
		default:
			return getInstance(valueName);
		}
	}
	public void set(String instanceName, Field field, String valueName)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		field.setAccessible(true);
		field.set(getInstance(instanceName), conevertStrToObjcet( valueName, field.getType().toString()));

	}
	public Object runMethod( String instanceName, Method method, String argmentNames[] ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?>[] cs = method.getParameterTypes();


		//Object[] argments = new String[cs.length];
		//argments[i] = obj;

		/* ArrayStoreException対策 */
		switch (cs.length) {
		case 0:
			return method.invoke(getInstance(instanceName) );
		case 1:
			return method.invoke(getInstance(instanceName),conevertStrToObjcet(argmentNames[0], cs[0].getName()));

		case 2:
			return method.invoke(getInstance(instanceName),conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName()));

		case 3:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()));

		case 4:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName()));

		case 5:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()));

		case 6:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					);

		case 7:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()));
		case 8:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
					);
		case 9:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
					, conevertStrToObjcet(argmentNames[8], cs[8].getName()));
		case 10:
			return method.invoke(getInstance(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
					, conevertStrToObjcet(argmentNames[8], cs[8].getName()), conevertStrToObjcet(argmentNames[9], cs[9].getName())
					);

		default:
			return method.invoke(getInstance(instanceName) );
		}


	}
	public boolean isArray(String instanceName) {
		Object obj = instances.get(instanceName);
		return obj.getClass().isArray();
	}
	public String[] getElementStrs(String instanceName) {
		Object obj = instances.get(instanceName);
		int length = Array.getLength(obj);
		String[] strs = new String[length];
		String base = instanceName.substring(0,instanceName.length() - 2);
		for(int i = 0;i < length; i++) {
			strs[i] = base + "[" + i +"]";
		}

		return strs;
	}

	public void createArray(String className, String instanceName, int length) throws IllegalAccessException, ClassNotFoundException {
		Class<?> c =  Class.forName(className);

		if (instances.containsKey(instanceName)) {
			throw new IllegalAccessException("instance name doubled");
		}
		Object array = Array.newInstance(c, length);
		classes.put(instanceName, c);
		instances.put(instanceName, array);
	}



	public void runConstructor(String className, String instanceName, Constructor<?> constructor, String[] argmentNames) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		if (instances.containsKey(instanceName)) {
			throw new IllegalAccessException("instance name doubled");
		}


		constructor.setAccessible(true);
		Class<?>[] cs = constructor.getParameterTypes();

		 Object createdObj;
		//Object[] argments = new String[cs.length];
		//argments[i] = obj;

		/* ArrayStoreException対策 */
			switch (cs.length) {
			case 0:
				createdObj =  constructor.newInstance();
				break;
			case 1:
				createdObj = constructor.newInstance(conevertStrToObjcet(argmentNames[0], cs[0].getName()));
				break;
			case 2:
				createdObj = constructor.newInstance(conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName()));
				break;
			case 3:
				createdObj = constructor.newInstance(
						conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()));
				break;
			case 4:
				createdObj = constructor.newInstance(
						conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName()));
				break;
			case 5:
				createdObj = constructor.newInstance(
						conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
						, conevertStrToObjcet(argmentNames[4], cs[4].getName()));
				break;
			case 6:
				createdObj = constructor.newInstance(
						 conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
						, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
						);
				break;
			case 7:
				createdObj = constructor.newInstance(
						 conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
						, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
						, conevertStrToObjcet(argmentNames[6], cs[6].getName()));
				break;
			case 8:
				createdObj = constructor.newInstance(
						 conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
						, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
						, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
						);
				break;
			case 9:
				createdObj = constructor.newInstance(
						 conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
						, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
						, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
						, conevertStrToObjcet(argmentNames[8], cs[8].getName()));
				break;
			case 10:
				createdObj = constructor.newInstance(
						 conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
						, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
						, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
						, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
						, conevertStrToObjcet(argmentNames[8], cs[8].getName()), conevertStrToObjcet(argmentNames[9], cs[9].getName())
						);
				break;
		default:
			createdObj =  constructor.newInstance();
		}
		instances.put(instanceName, createdObj);
		classes.put(instanceName, Class.forName(className));
	}

	void setElement(String arrayName,int index, String instanceName ) {
		Object array = instances.get(arrayName);
		Object instance = getInstance(instanceName);
		Array.set(array, index, instance);
	}


}
