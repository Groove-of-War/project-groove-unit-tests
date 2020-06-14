import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CombatTest {

    private static String file = "solveDamage/combat.lua";
    private static Globals globals = JsePlatform.standardGlobals();
    private static LuaValue lua = globals.loadfile(file);

    @BeforeClass
    public void setUp() {
        lua = lua.call();
    }

    @Test()
    public void solveDamageAverage50() {
        Varargs args = lua
                .get("execute")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.45), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),55);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.45), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),45);
    }

    @Test()
    public void solveDamageAverage10() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.05), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),11);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.05), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),9);
    }

    @Test()
    public void solveDamageAverage20() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.20), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),28);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.20), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),23);
    }

    @Test()
    public void solveDamageAverage100() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.95), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),105);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.95), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),95);
    }

    @Test()
    public void solveDamageWoundedAttacker() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.80), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(0.5), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),47);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.80), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(0.5), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),38);
    }


    @Test()
    public void solveDamageCrit() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.35), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.5), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),65);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.35), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.0), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.5), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),55);
    }

    @Test()
    public void solveDamageMountain() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.55), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.4), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),40);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.55), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(0.4), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),32);
    }

    @Test()
    public void solveDamageRiver() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.95), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(-0.2), // Terrain Defense
                                LuaValue.valueOf(1.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),125);
        args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.95), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(1.0), // Attacker HP
                                LuaValue.valueOf(1.0), // Defender HP
                                LuaValue.valueOf(-0.2), // Terrain Defense
                                LuaValue.valueOf(0.0), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.0), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),115);
    }

    @Test()
    public void solveDamageMultipleValues() {
        Varargs args = lua
                .get("solveDamage")
                .invoke(
                        new LuaValue[]{LuaValue.NIL, //This is the argument for self. Not needed in this case since it's not used
                                LuaValue.valueOf(0.75), // Weapon Damage (Average - 5 damage)
                                LuaValue.valueOf(0.80), // Attacker HP
                                LuaValue.valueOf(0.60), // Defender HP
                                LuaValue.valueOf(-0.1), // Terrain Defense
                                LuaValue.valueOf(0.40), // Random value (0.0 for low roll or 1.0 for high roll)
                                LuaValue.valueOf(1.2), // Crit multiplier
                                LuaValue.valueOf(1.0)} // Generic damage multiplier
                );
        Assert.assertEquals(args.arg1().checkint(),84);
    }
}
