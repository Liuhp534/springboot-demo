package cn.liuhp.common;

import cn.liuhp.pojo.EnumInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-16 12:46
 */
public class PackageUtil {

    public static void main(String[] args) throws Exception {
        /*String packageName = "cn.liuhp.pojo";

        List<String> classNames = getClassName(packageName);
        for (String className : classNames) {
            System.out.println(className);
            Class clazz = Class.forName(className);

        }*/

        /*Class clazz = Class.forName("cn.liuhp.pojo.ResponseEnum");
        System.out.println(Arrays.asList(clazz.getInterfaces()));
        if(clazz.isEnum()) {
            System.out.println(Arrays.asList(clazz.getEnumConstants()));
        }*/

        List<EnumInterface> allEnums = PackageUtil.analysisPackage("cn.liuhp.**");
        for (EnumInterface enumInterface : allEnums) {
            System.out.println(enumInterface);
        }
    }

    public static List<EnumInterface> analysisPackage(String packageStr) {
        List<EnumInterface> allEnums = new ArrayList<>(256);
        List<String> classNames = getClassName(packageStr);
        try {
            for (String className : classNames) {
                Class clazz = Class.forName(className);
                if (isEnumInterface(clazz)) {
                    EnumInterface[] temps = (EnumInterface[]) clazz.getEnumConstants();
                    allEnums.addAll(Arrays.asList(temps));
                }
            }
        } catch (Exception e) {
            System.out.println("异常了");
        }
        return allEnums;
    }

    private static boolean isEnumInterface(Class clazz) {
        if (!clazz.isEnum()) {
            return Boolean.FALSE;
        }
        Class[] clazzInterfaces = clazz.getInterfaces();
        for (Class c : clazzInterfaces) {
            if (c.getName().equalsIgnoreCase("cn.liuhp.pojo.EnumInterface")) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    public static List<String> getClassName(String packageName) {
        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
        List<String> fileNames = getClassName(filePath, null);
        return fileNames;
    }

    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }

        return myClassName;
    }
}
