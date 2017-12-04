package org.zwx.test;

import org.junit.Test;

import javax.script.*;

public class SimpleTest {

    @Test
    public void test() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();


        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("python");
        Compilable compilable = (Compilable) scriptEngine;

        CompiledScript compiledScript = compilable.compile("b = 2");
        compiledScript.eval();
        ScriptContext ctx2 = scriptEngine.getContext();




        Compilable compiler = (Compilable) scriptEngineManager.getEngineByName("python");

        CompiledScript scriptFun = compiler.compile("def fun1():\r    print('fun1')");

        CompiledScript script1 = compiler.compile("a = '1'");
        script1.eval();

        CompiledScript script2 = compiler.compile("print(b)");

        ScriptContext ctx = ((ScriptEngine) compiler).getContext();
        script2.eval(ctx2);
//        scriptFun.eval();





//        CompiledScript compiledScript = compiler.compile("print 'hello python'");
//        Compilable compile = (Compilable) scriptEngine;
//        CompiledScript compiledScript = compile.compile("print 'hello python'");

        Invocable invocable = (Invocable) compiler;
//        invocable.invokeFunction("fun1");



    }
}
