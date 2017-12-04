package org.zwx.jython;

import javax.script.*;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleJythonExecutor {


    public void execute() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("python");

        Bindings binding = scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE);


        Compilable compile = (Compilable) scriptEngine;
        CompiledScript compiledScript = compile.compile("def fun1():\r    print(\"hello\")");
        compiledScript.eval();
        compiledScript = compile.compile("def fun22():\r    print(\"hello22\")");

        compiledScript.eval();
        Invocable invocable = (Invocable) scriptEngine;
        invocable.invokeFunction("fun1");
        invocable.invokeFunction("fun22");



        scriptEngine.eval("def fun1():\r    print(\"hello\")");


    }


}
