package org.zwx.jython;

import org.junit.Test;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.get;

public class TestBinding {

    @Test
    public void test() throws ScriptException {
        ScriptEngine scriptEngine = JythonUtil.getScriptEngine();
        Bindings bindings = scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE);
        Object[] obj = new Object[]{"a", 1};
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "val1");
        map.put("key2", 200);
        bindings.put("msg", obj);
        bindings.put("map", map);
        scriptEngine.eval("print(msg[1])");
        scriptEngine.eval("map['key3']='hello map'");
        scriptEngine.eval("map['bool'] = True");
        map = (Map<String, Object>) bindings.get("map");
        System.out.println("python add bool:" + map.get("bool"));

        if (Boolean.TRUE.equals(map.get("bool"))) {
            System.out.println("return val is true");
        }
    }

}
