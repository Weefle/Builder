package net.jrbudda.builder;

import com.denizenscript.denizen.BukkitScriptEntryData;
import com.denizenscript.denizen.npc.traits.AssignmentTrait;
import com.denizenscript.denizen.objects.NPCTag;
import com.denizenscript.denizencore.scripts.ScriptRegistry;
import com.denizenscript.denizencore.scripts.containers.core.TaskScriptContainer;

import net.citizensnpcs.api.npc.NPC;

public class DenizenSupport {

    public static boolean runTask(String taskName, NPC npc) {
        NPCTag dnpc = NPCTag.mirrorCitizensNPC(npc);
        TaskScriptContainer task = ScriptRegistry.getScriptContainerAs(taskName, TaskScriptContainer.class);
        if (task != null) {
            task.runTaskScript(new BukkitScriptEntryData(null, dnpc), null);
            return true;
        }
        return false;
    }

    public static void runAction(NPC npc, String action) throws Exception {
        if (npc.hasTrait(AssignmentTrait.class)) {
            NPCTag dnpc = NPCTag.mirrorCitizensNPC(npc);
            dnpc.action(action, null);
        }
    }
}