package interpret;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Interpret {
	private Class<?> classObj;
	private Object instance = null;

	private HashMap<String, Object> instances = new HashMap<String, Object>();
	private HashMap<String, Class<?>> classes = new HashMap<String, Class<?>>();

	public Interpret() {

	}

	public String[] getFirldLists(String className) throws ClassNotFoundException {

		classObj = Class.forName(className);
		System.out.println(className);
		Member[] members = classObj.getFields();

		String result[] = new String[members.length];

		for (int i = 0; i < members.length; i++) {
			result[i] = members[i].getName();
			System.out.println(result[i]);
		}
		return result;
	}

	public String[] getFirldListsOfInstance(String name) throws ClassNotFoundException {

		classObj = classes.get(name);
		System.out.println(name);
		Member[] members = classObj.getFields();

		String result[] = new String[members.length];

		for (int i = 0; i < members.length; i++) {
			result[i] = members[i].getName();
			System.out.println(result[i]);
		}
		return result;
	}

	public Method[] getMethodLists(String className) throws ClassNotFoundException {

		classObj = Class.forName(className);
		System.out.println(className);
		return classObj.getMethods();
	}

	public Method[] getMethodListsOfInstance(String name) throws ClassNotFoundException {

		classObj = classes.get(name);
		System.out.println(classObj);
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

	public void createInstance() throws InstantiationException, IllegalAccessException {
		instance = classObj.newInstance();
	}

	public void createInstance(String className, String objName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		if (instances.containsKey(objName)) {
			throw new InstantiationException();
		}

		classObj = Class.forName(className);
		instance = classObj.newInstance();
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
			field.set(instance, valueName);
			break;
		}
	}

	public void set(String InstanceName, Field field, String valueName, boolean useCreatedInstance)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		field.setAccessible(true);

		if (useCreatedInstance) {
			field.set(instances.get(InstanceName), instances.get(valueName));
		} else {
			setPrimitive(InstanceName, field, valueName);
		}
	}

}
