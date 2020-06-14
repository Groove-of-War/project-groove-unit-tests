import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GrooveDiplomacyTest {

    private static String file = "diplomacy/groove_diplomacy.lua";
    private static Globals globals = JsePlatform.standardGlobals();
    private static LuaValue lua = globals.loadfile(file);
    private static LuaTable unitPosition = LuaValue.tableOf();
    private static LuaTable targetPosition = LuaValue.tableOf();
    private static LuaTable unit = LuaValue.tableOf();
    private static LuaTable path = LuaValue.tableOf();

    @BeforeClass
    public void setUp() {
        lua = lua.call();
        unitPosition.set("x", 3);
        unitPosition.set("y", 4);
        targetPosition.set("x", 3);
        targetPosition.set("y", 5);

        unit.set("pos", unitPosition);
        unit.set("id", 20);
        unit.set("playerId", 1);
    }

    @Test()
    public void diplomacy() {
        Varargs args = lua
                .get("execute")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                unit, // unit
                                targetPosition, // targetPos
                                LuaValue.NIL, // strParam
                                path} // Path
                );
    }
}
