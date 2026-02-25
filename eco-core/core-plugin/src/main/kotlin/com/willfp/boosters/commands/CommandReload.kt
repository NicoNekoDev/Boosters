package com.willfp.boosters.commands

import com.willfp.boosters.plugin
import com.willfp.eco.core.Prerequisite
import com.willfp.eco.core.command.impl.Subcommand
import org.bukkit.command.CommandSender

object CommandReload : Subcommand(
    plugin,
    "reload",
    "boosters.command.reload",
    false
) {

    override fun onExecute(sender: CommandSender, args: List<String>) {
        val runnable: Runnable = {
            plugin.reload()
            sender.sendMessage(plugin.langYml.getMessage("reloaded"))
        }
        if (Prerequisite.HAS_FOLIA.isMet)
            plugin.scheduler.runTask(runnable) // run on global thread
        else
            runnable.run()
    }
}