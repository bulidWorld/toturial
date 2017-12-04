package org.zwx.jython;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JythonUtil {

    private static ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

    public static ScriptEngine getScriptEngine() {
        return scriptEngineManager.getEngineByName("python");
    }

}
