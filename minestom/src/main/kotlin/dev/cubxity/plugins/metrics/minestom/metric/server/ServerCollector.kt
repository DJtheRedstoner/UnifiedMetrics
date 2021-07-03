/*
 *     UnifiedMetrics is a fully-featured metrics collection plugin for Minecraft servers.
 *     Copyright (C) 2021  Cubxity
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.cubxity.plugins.metrics.minestom.metric.server

import dev.cubxity.plugins.metrics.api.metric.collector.MetricCollector
import dev.cubxity.plugins.metrics.api.metric.data.GaugeSample
import dev.cubxity.plugins.metrics.api.metric.data.MetricSample
import net.minestom.server.MinecraftServer

class ServerCollector : MetricCollector {
    override fun collect(): List<MetricSample> {
        val extensionCount = MinecraftServer.getExtensionManager().extensions.size
        val playerCount = MinecraftServer.getConnectionManager().onlinePlayers.size

        return listOf(
            GaugeSample("minecraft_plugins", extensionCount),
            GaugeSample("minecraft_players_count", playerCount),
            GaugeSample("minecraft_players_max", playerCount + 1) // Minestom does not have a "max players" count
        )
    }
}