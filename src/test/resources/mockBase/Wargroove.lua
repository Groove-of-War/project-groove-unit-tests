local Wargroove = {}

-- Capture wargrooveAPI
local api = wargrooveAPI
wargrooveAPI = nil


-- Caches
local caches = {
    getUnitClass = {},
    getWeapon = {},
    getTerrainDefenceAt = {},
    getTerrainMovementCostAt = {},
    getBaseTerrainDefenceAt = {},
    getTerrainNameAt = {},

    getTerrainByName = {},
    getGroove = {},
    getPlayerTeam = {},
    getPlayerChildOf = {}
}

local activeBuffs = {}

local difficulty = {
    damageMultiplier = 1.0
}

function Wargroove.clearUnitPositionCache()
    caches.getUnitIdAt = {}
end

function Wargroove.clearPlayerCache()
    caches.getPlayerTeam = {}
    caches.getPlayerChildOf = {}
end

function Wargroove.applyBuffs()
end

function Wargroove:doPostCombat(unitId, isAttacker)
end

function Wargroove.clearCaches()
    Wargroove.clearUnitPositionCache()
    Wargroove.clearPlayerCache()
    caches.getUnitById = {}
    caches.getTerrainDefenceAt = {}
    caches.getSkyDefenceAt = {}
    caches.getTerrainMovementCostAt = {}
    caches.getBaseTerrainDefenceAt = {}
    caches.getTerrainNameAt = {}
    caches.getTerrainByName = {}
    caches.getGroove = {}
    caches.getWeapon = {}
    caches.getUnitClass = {}
end

Wargroove.clearCaches()

function cachedCall(cache, cacheKey, f, ...)
    local cachedResult = cache[cacheKey]
    if cachedResult ~= nil then
        return cachedResult[1]
    else
        local result = f(...)
        cache[cacheKey] = {result}
        return result
    end
end

local function xyToCacheKey(x, y)
    return x * 65536 + y
end


-- Internal storage
local wargrooveState = {
    turnNumber = 0,
    currentPlayerId = 0
}


-- User-facing functions
function Wargroove.getWeapon(weaponId, unitClassId)

end


function Wargroove.getUnitClass(unitClassId)
end


function Wargroove.getUnitById(unitId)
end


function Wargroove.getUnitIdAtXY(x, y)
end


function Wargroove.setUnitIdAtXY(x, y, unitId)
end


function Wargroove.getUnitIdAt(pos)
end


function Wargroove.getUnitAtXY(x, y)
end


function Wargroove.getUnitAt(pos)
end


function Wargroove.getPlayerTeam(playerId)
end

function Wargroove.getPlayerChildOf(playerId)
end


function Wargroove.setPlayerTeam(playerId, teamId)
end


function Wargroove.areAllies(playerId1, playerId2)
end


function Wargroove.areEnemies(playerId1, playerId2)
end


function Wargroove.isNeutral(playerId)
end


function Wargroove.startCombat(attacker, defender, path)
end


function Wargroove.startCapture(attacker, defender, attackerPos)
end


function Wargroove.spawnUnit(playerId, pos, unitType, turnSpent, startAnimation)
end


function Wargroove.updateUnit(unit)
end


function Wargroove.updateUnits(units)
end


function Wargroove.removeUnit(unitId)
end

function Wargroove.doLuaDeathCheck(unitId)
end

function Wargroove.changeMoney(playerId, delta)
    if playerId == 1 then
        assert(delta == 100)
    end

    if playerId == 2 then
        assert(delta == -100)
    end
end


function Wargroove.setMoney(playerId, value)
end


function Wargroove.getMoney(playerId)
end


function Wargroove.canStandAt(unitClass, pos)
end


local unitPosStack = {}

function Wargroove.pushUnitPos(unit, pos)
end


function Wargroove.popUnitPos()
end


function Wargroove.getTargetsInRangeAfterMove(unit, endPos, pos, range, targetType)
end


function Wargroove.getTargetsInRange(pos, range, targetType)
end


function Wargroove.getWeaponDamage(weapon, target)
end

function Wargroove.getWeaponDamageForceGround(weaponId, target)
end

function Wargroove.isAnybodyElseAt(unit, pos)
end


function Wargroove.loadInTransport(transport, unit)
end


function Wargroove.unloadFromTransport(transport, unit, position)
end

function Wargroove.getTerrainByName(name)
end

function Wargroove.getTerrainNameAt(pos)
end

function Wargroove.getTerrainDefenceAt(pos)
end

function Wargroove.getBaseSkyDefence()
end

function Wargroove.getSkyDefenceAt(pos)
end

function Wargroove.getTerrainMovementCostAt(pos)
end

function Wargroove.getBaseTerrainDefenceAt(pos)
end

function Wargroove.getValueFromCache(cache, cacheKey)
end

function Wargroove.putValueIntoCache(cache, cacheKey, result)
end

function Wargroove.setTerrainDefenceAt(pos, newDefence)
end

function Wargroove.setSkyDefenceAt(pos, newDefence)
end

function Wargroove.getAllUnitIdsForPlayer(playerId, includeChildren)
end


function Wargroove.getAllUnitsForPlayer(playerId, includeChildren)
end


function Wargroove.getCurrentWeather()
end


function Wargroove.getGroove(grooveId)
end


function Wargroove.getMapTriggers()
end


function Wargroove.getLocationById(locationId)
end


function Wargroove.getUnitsAtLocation(location)
end


function Wargroove.getTurnNumber()
end


function Wargroove.getCurrentPlayerId()
end


function Wargroove.startCutscene(id)
end


function Wargroove.giveVictory(playerId)
end


function Wargroove.eliminate(playerId)
end


function Wargroove.waitFrame()
end


function Wargroove.waitTime(time)
end



function Wargroove.getNumberOfOpponents(playerId)
end


function Wargroove.showMessage(string)
end


function Wargroove.showDialogueBox(expression, character, message, shout)
end


function Wargroove.getMapVariables(id)
end


function Wargroove.trackCameraTo(pos)
end


function Wargroove.spawnMapAnimation(pos, radius, name, sequence, layer, offset, facing)
end

function Wargroove.spawnPaletteSwappedMapAnimation(pos, radius, name, playerId, sequence, layer, offset)
end

function Wargroove.playUnitAnimation(unitId, sequence)
end

function Wargroove.playUnitAnimationOnce(unitId, sequence)
end

function Wargroove.pseudoRandomFromString(str)
end

function Wargroove.isRNGEnabled()
end


function Wargroove.canPlayerSeeTile(player, tile)
end

function Wargroove.canCurrentlySeeTile(tile)
end

function Wargroove.canCurrentlySeeArea(centre, radius)
end


function Wargroove.canPlayerRecruit(player, unitClassId)
end


function Wargroove.setAIProfile(player, profile)
end

function Wargroove.setWeather(weatherFrequency, daysAhead)
end


function Wargroove.setAIRestriction(unitId, restriction, value)
end

function Wargroove.forceAction(selectableUnitIds, endPositions, targetPositions, action, autoEnd, expression, commander, dialogue)
end

function Wargroove.forceOpenTutorial(tutorialId, selectableTargets, expression, commander, dialogue, mapFlag, mapFlagValue)
end

function Wargroove.queueForceAction(selectableUnitIds, endPositions, targetPositions, action, autoEnd, expression, commander, dialogue)
end

function Wargroove.queueForceOpenTutorial(tutorialId, selectableTargets, expression, commander, dialogue, mapFlag, mapFlagValue)
end

function Wargroove.addTutorial(tutorialId, selectableTargets, mapFlag, mapFlagValue)
end

function Wargroove.playMapSound(sound, pos)
end

function Wargroove.playPositionlessSound(sound)
end

function Wargroove.openRecruitMenu(player, recruitBaseId, recruitBasePos, unitClassId, units, costMultiplier)
end

function Wargroove.recruitMenuIsOpen()
end

function Wargroove.popRecruitedUnitClass()
end

function Wargroove.openUnloadMenu(usedUnits)
end

function Wargroove.unloadMenuIsOpen()
end

function Wargroove.getUnloadedUnitId()
end

function Wargroove.getUnloadVerb()
end

function Wargroove.finishVerbPreExecute(shouldExecute, strParam)
end

function Wargroove.cancelVerbExecute()
end

function Wargroove.selectTarget()
end

function Wargroove.waitingForSelectedTarget()
end

function Wargroove.getSelectedTarget()
end

function Wargroove.setSelectedTarget(targetPos)
end

function Wargroove.clearSelectedTarget()
end

function Wargroove.displayTarget(targetPos)
end

function Wargroove.clearDisplayTargets()
end

function Wargroove.displayBuffVisualEffect(parentId, playerId, animation, startSequence, alpha)
end

function Wargroove.clearBuffVisualEffect(parentId)
end

function Wargroove.getBestUnitToRecruit(fromUnits)
end

function Wargroove.getAIUnitRecruitScore(unitClassId, position)
end

function Wargroove.getAILocationScore(unitClassId, position)
end

function Wargroove.getAIUnitValue(unitId, position)
end

function Wargroove.getAICanLookAhead(unitId)
end

function Wargroove.getAIUnitValueWithHealth(unitId, position, health)
end

function Wargroove.getAIBraveryBonus()
end

function Wargroove.getAIAttackBias()
end

function Wargroove.moveUnitToOverride(unitId, endPos, offsetX, offsetY, speed)
end

function Wargroove.isLuaMoving(unitId)
end

function Wargroove.spawnUnitEffect(parentUnitId, name, sequence, startAnimation, inFront)
end

function Wargroove.deleteUnitEffect(entityId, endAnimation)
end

function Wargroove.setIsUsingGroove(unitId, isUsing)
end

function Wargroove.playGrooveCutscene(unitId)
end

function Wargroove.playGrooveCutsceneForCharacter(character)
end

function Wargroove.playGrooveEffect()
end

function Wargroove.setVisibleOverride(unitId, visible)
end

function Wargroove.unsetVisibleOverride(unitId)
end

function Wargroove.playCutscene(cutsceneId)
end

function Wargroove.isCutscenePlaying()
end

function Wargroove.setFacingOverride(unitId, newFacing)
end

function Wargroove.unsetFacingOverride(unitId)
end

function Wargroove.highlightLocation(location, highlightId, colour, hideOnSelection, hideOnAction, showOnUnitSelection, showOnEndPosSelection, showOnActionSelected)
end

-- Invoked by native code

function Wargroove.setTurnInfo(turnNumber, currentPlayerId)
end

local Events = nil
local Resumable = nil

function Wargroove.checkTriggers(state)
end

function Wargroove.checkConditions(conditions)
end

function Wargroove.runActions(actions)
end

function Wargroove.setMapFlag(flagId, value)
end

function Wargroove.reportUnitDeath(id, attackerId, attackerPlayerId, attackerUnitClass)
end

function Wargroove.isPlayerVictorious(playerId)
end

function Wargroove.getNumberOfStars()
end

function Wargroove.getNumberOfStarsAfterVictory(turnN)
end

function Wargroove.resumeExecution(time)
end

function Wargroove.chooseFish(unitPos)
end

function Wargroove.openFishingUI(unitPos, fishId)
end

function Wargroove.isLocalPlayer(playerId)
end

function Wargroove.playCredits(creditsType)
end

function Wargroove.setMatchSeed(matchSeed)
end

function Wargroove.updateFogOfWar(matchseed)
end

function Wargroove.changeObjective(objective)
end

function Wargroove.showObjective()
end

function Wargroove.moveLocationTo(locationId, position)
end

function Wargroove.setMapMusic(music)
end

function Wargroove.getMapSize()
end

function Wargroove.isHuman(playerId)
end

function Wargroove.setDifficulty(dmgMult)
end

function Wargroove.getDamageMultiplier()
end

function Wargroove.setUnitState(unit, key, value)
end

function Wargroove.getUnitState(unit, key)
end

function Wargroove.notifyEvent(event, playerId)
end

return Wargroove
