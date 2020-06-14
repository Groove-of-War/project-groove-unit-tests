local Wargroove = require "diplomacy/wargroove"


local Diplomacy = {}

function Diplomacy:execute(unit, targetPos, strParam, path)
    Wargroove.setIsUsingGroove(unit.id, true)
    Wargroove.updateUnit(unit)

    local facingOverride = ""
    if targetPos.x > unit.pos.x then
        facingOverride = "right"
    elseif targetPos.x < unit.pos.x then
        facingOverride = "left"
    end

    local grooveAnimation = "groove"
    if targetPos.y < unit.pos.y then
        grooveAnimation = "groove_up"
    elseif targetPos.y > unit.pos.y then
        grooveAnimation = "groove_down"
    end

    if facingOverride ~= "" then
        Wargroove.setFacingOverride(unit.id, facingOverride)
    end

    Wargroove.playUnitAnimation(unit.id, grooveAnimation)
    Wargroove.playMapSound("mercival/mercivalGroove", targetPos)
    Wargroove.waitTime(3.0)

    Wargroove.playGrooveEffect()
    Wargroove.unsetFacingOverride(unit.id)
    Wargroove.playUnitAnimation(unit.id, "groove_end")
    Wargroove.openFishingUI(unit.pos, "boot")
    Wargroove.waitTime(0.5)
    Wargroove.playMapSound("mercival/mercivalGrooveCatch", unit.pos)

    local endPos = unit.pos
    if path and #path > 0 then
        endPos = path[#path]
    end
    local targetUnit = Wargroove.getUnitAt(targetPos);
    Wargroove.changeMoney(targetUnit.playerId, -100)
    Wargroove.changeMoney(unit.playerId, 100)
    targetUnit:setHealth(100, unit.id)
    targetUnit.playerId = unit.playerId
    Wargroove.updateUnit(targetUnit)

    Wargroove.waitTime(2.5)
end


return Diplomacy
