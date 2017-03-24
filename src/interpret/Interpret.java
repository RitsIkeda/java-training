package interpret;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class Interpret {
	private  Class<?> classObj;
	private  Object instance = null;

	public Interpret() {

	}

	public String[] getFirldLists(String className) throws ClassNotFoundException {

		classObj = Class.forName(className);
		System.out.println(className);
		Member[] members = classObj.getFields();

		String result[] = new String[members.length];

		for(int i = 0; i < members.length; i++) {
			result[i] = members[i].getName();
			System.out.println(result[i]);
		}
		return result;

	}

	public void createInstance() throws InstantiationException, IllegalAccessException {
		instance = classObj.newInstance();
	}

	public Field getField(String name) throws NoSuchFieldException, SecurityException  {
		Field field = classObj.getField(name);
		return field;
	}
	public Object getInstance() {
		return instance;
	}

	public void set(String fieldName, String valueName, String typeName ) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field field = classObj.getField(fieldName);
		field.setAccessible(true);

		switch(typeName) {
		case "int":
			field.setInt(instance, Integer.parseInt(valueName));
			break;

		case "char":
			field.setChar(instance, valueName.charAt(0));
			break;

		case "boolean":
			field.setBoolean(instance, Boolean.parseBoolean(valueName));
			break;

		case "byte":
			field.setByte(instance, Byte.parseByte(valueName));
			break;

		case "double":
			field.setDouble(instance, Double.parseDouble(valueName));
			break;

		case "float":
			field.setFloat(instance, Float.parseFloat(valueName));
			break;

		case "long":
			field.setLong(instance, Long.parseLong(valueName));
			break;

		case "short":
			field.setShort(instance, Short.parseShort(valueName));
			break;

		case "String":
		default:
			field.set(instance, valueName);
			break;
		}
	}

}
