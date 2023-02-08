package javassist;

import com.powernode.bank.dao.AccountDao;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author iyeee
 * @Date 2023/2/9 1:46
 * @Version 1.0.1
 */
public class JavassistTest {

    @Test
    public void testGenerateImpl2() throws Exception{
        ClassPool aDefault = ClassPool.getDefault();
        CtClass ctClass = aDefault.makeClass("com.powernode.bank.dao.impl.AccountDaoImpl");
        CtClass ctClass1 = aDefault.makeInterface("com.powernode.bank.dao.AccountDao");
        ctClass.addInterface(ctClass1);
        Method[] declaredMethods = AccountDao.class.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(method -> {
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append("public ");
                stringBuilder.append(method.getReturnType().getName());
                stringBuilder.append(" ");
                stringBuilder.append(method.getName());
                stringBuilder.append("(");
                stringBuilder.append("){System.out.println(1111);};");
                 CtMethod ctMethod = CtMethod.make(stringBuilder.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }

        });

        Class<?> aClass = ctClass.toClass();
        AccountDao o = (AccountDao)aClass.newInstance();
        o.delete3();

    }



    @Test
    public void testGenerateImpl() throws Exception{
        ClassPool aDefault = ClassPool.getDefault();
        CtClass ctClass = aDefault.makeClass("com.powernode.bank.dao.impl.AccountDaoImpl");
        CtClass ctClass1 = aDefault.makeInterface("com.powernode.bank.dao.AccountDao");
        ctClass.addInterface(ctClass1);
        CtMethod ctMethod= CtMethod.make("public void delete(){System.out.println(1111);}", ctClass);
        ctClass.addMethod(ctMethod);
        Class<?> aClass = ctClass.toClass();
        AccountDao o = (AccountDao)aClass.newInstance();
        o.delete();

    }


    @Test
    public void testGenerateFirstClass() throws CannotCompileException, InstantiationException, IllegalAccessException, ClassNotFoundException, NotFoundException, NoSuchMethodException, InvocationTargetException {
        ClassPool aDefault = ClassPool.getDefault();
        CtClass ctClass = aDefault.makeClass("com.powernode.bank.dao.impl.AccountDaoImpl");
        String methodCode="public void insert(){System.out.println(123);}";
        CtMethod make = CtMethod.make(methodCode, ctClass);
        ctClass.addMethod(make);
        ctClass.toClass();
        Class<?> aClass = Class.forName("com.powernode.bank.dao.impl.AccountDaoImpl");
        Object o = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("insert");
        method.invoke(o);


    }
}
