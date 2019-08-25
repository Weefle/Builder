package net.jrbudda.builder;

import net.aufdemrand.denizen.BukkitScriptEntryData;
import net.aufdemrand.denizen.npc.traits.AssignmentTrait;
import net.aufdemrand.denizen.objects.dNPC;
import net.aufdemrand.denizencore.scripts.ScriptRegistry;
import net.aufdemrand.denizencore.scripts.containers.core.TaskScriptContainer;
import net.citizensnpcs.api.npc.NPC;

public class DenizenSupport {

    public static boolean runTask(String taskName, NPC npc) {
        dNPC dnpc = dNPC.mirrorCitizensNPC(npc);
        TaskScriptContainer task = ScriptRegistry.getScriptContainerAs(taskName, TaskScriptContainer.class);
        if (task != null) {
            task.runTaskScript(new BukkitScriptEntryData(null, dnpc), null);
            return true;
        }
        return false;
    }

    public static void runAction(NPC npc, String action) throws Exception {
        if (npc.hasTrait(AssignmentTrait.class)) {
            dNPC dnpc = dNPC.mirrorCitizensNPC(npc);
            dnpc.action(action, null);
        }
    }
}