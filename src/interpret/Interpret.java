package interpret;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;

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
		Member[] members = classObj.getFields();

		String result[] = new String[members.length];

		for (int i = 0; i < members.length; i++) {
			result[i] = members[i].getName();
			//System.out.println(result[i]);
		}
		return result;
	}

	public String[] getFirldListsOfInstance(String name) throws ClassNotFoundException {

		 Class<?>  classObj = classes.get(name);
		//System.out.println(name);
		Member[] members = classObj.getFields();

		String result[] = new String[members.length];

		for (int i = 0; i < members.length; i++) {
			result[i] = members[i].getName();
			System.out.println(result[i]);
		}
		return result;
	}

	public Method[] getMethodLists(String className) throws ClassNotFoundException {

		 Class<?>  classObj = Class.forName(className);
		//System.out.println(className);
		return classObj.getMethods();
	}

	public Method[] getMethodListsOfInstance(String name) throws ClassNotFoundException {

		 Class<?> classObj = classes.get(name);
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


	public Field getField(String instanceName, String fieldName) throws NoSuchFieldException, SecurityException {
		Field field = classes.get(instanceName).getField(fieldName);
		return field;
	}

	public Object getInstance(String name) {
		return instances.get(name);
	}

	public void setPrimitive(String InstanceName, Field field, String valueName)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		switch (field.getType().toString()) {
		case "int":
			field.setInt(instances.get(InstanceName), Integer.parseInt(valueName));
			break;

		case "char":
			field.setChar(instances.get(InstanceName), valueName.charAt(0));
			break;

		case "boolean":
			field.setBoolean(instances.get(InstanceName), Boolean.parseBoolean(valueName));
			break;

		case "byte":
			field.setByte(instances.get(InstanceName), Byte.parseByte(valueName));
			break;

		case "double":
			field.setDouble(instances.get(InstanceName), Double.parseDouble(valueName));
			break;

		case "float":
			field.setFloat(instances.get(InstanceName), Float.parseFloat(valueName));
			break;

		case "long":
			field.setLong(instances.get(InstanceName), Long.parseLong(valueName));
			break;

		case "short":
			field.setShort(instances.get(InstanceName), Short.parseShort(valueName));
			break;

		case "String":
		default:
			field.set(instances.get(InstanceName), valueName);
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
			return valueName;
		default:
			return instances.get(valueName);
		}
	}
	public void set(String instanceName, Field field, String valueName)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		field.setAccessible(true);
		field.set(instances.get(instanceName), conevertStrToObjcet( valueName, field.getType().toString()));

	}
	public Object runMethod(String instanceName, Method method, String argmentNames[] ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?>[] cs = method.getParameterTypes();



		//Object[] argments = new String[cs.length];
		//argments[i] = obj;

		/* ArrayStoreException対策 */
		switch (cs.length) {
		case 0:
			return method.invoke(instances.get(instanceName) );
		case 1:
			return method.invoke(instances.get(instanceName),conevertStrToObjcet(argmentNames[0], cs[0].getName()));

		case 2:
			return method.invoke(instances.get(instanceName),conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName()));

		case 3:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()));

		case 4:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName()));

		case 5:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()));

		case 6:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					);

		case 7:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()));
		case 8:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
					);
		case 9:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
					, conevertStrToObjcet(argmentNames[8], cs[8].getName()));
		case 10:
			return method.invoke(instances.get(instanceName)
					, conevertStrToObjcet(argmentNames[0], cs[0].getName()), conevertStrToObjcet(argmentNames[1], cs[1].getName())
					, conevertStrToObjcet(argmentNames[2], cs[2].getName()), conevertStrToObjcet(argmentNames[3], cs[3].getName())
					, conevertStrToObjcet(argmentNames[4], cs[4].getName()), conevertStrToObjcet(argmentNames[5], cs[5].getName())
					, conevertStrToObjcet(argmentNames[6], cs[6].getName()), conevertStrToObjcet(argmentNames[7], cs[7].getName())
					, conevertStrToObjcet(argmentNames[8], cs[8].getName()), conevertStrToObjcet(argmentNames[9], cs[9].getName())
					);

		default:
			return method.invoke(instances.get(instanceName) );
		}


	}
}









