package org.zwx.jython;

import org.junit.Test;

import javax.script.*;

public class TestScriptContext {


    public ScriptContext getContext() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("python");

//        Compilable compiler = (Compilable) scriptEngine;
//
//        compiler.compile("a=2");
        scriptEngine.eval("var1='val1'");
        scriptEngine.eval("var2='val2'");

        return scriptEngine.getContext();

    }


    @Test
    public void executeWithCtx() throws ScriptException {
        ScriptContext scriptContext = getContext();

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("python");
        scriptEngine.eval("print(var1)", scriptContext);
    }
}
