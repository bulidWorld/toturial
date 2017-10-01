package org.zwx.test;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SimpleTest {

    @Test
    public void test() throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("python");

        scriptEngine.eval("print \"hello python\"");
    }
}
