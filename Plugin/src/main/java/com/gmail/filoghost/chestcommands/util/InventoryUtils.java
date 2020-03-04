/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.gmail.filoghost.chestcommands.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

	public static boolean hasInventoryFull(Player player) {
		return player.getInventory().firstEmpty() == -1;
	}

	public static boolean containsAtLeast(Inventory inv, Material material, int minAmount) {
		int contained = 0;

		for (ItemStack item : inv.getContents()) {
			if (item != null && item.getType() == material) {
				contained += item.getAmount();
			}
		}

		return contained >= minAmount;
	}

	public static boolean containsAtLeast(Inventory inv, Material material, int minAmount, short data) {
		int contained = 0;

		for (ItemStack item : inv.getContents()) {
			if (item != null && item.getType() == material && item.getDurability() == data) {
				contained += item.getAmount();
			}
		}

		return contained >= minAmount;
	}

	// Except for equipments.
	public static int countOpenSlots(Player p)
    {
        int count = 0;
        if (p == null)
            return -1;

        ItemStack[] items = p.getInventory().getContents();
        // Don't count equipment or offhand as empty slots
        for (int i = 0; i < 36; i++)
            if ((items[i] == null || items[i].getType() == Material.AIR))
                count++;

        return count;
    }
}
