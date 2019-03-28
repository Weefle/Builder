package net.jrbudda.builder;

import java.util.ArrayList;
import java.util.List;

import org.anhcraft.spaciouslib.utils.CommonUtils;
import org.anhcraft.spaciouslib.utils.Group;
import org.anhcraft.spaciouslib.utils.InitialisationValidator;
import org.anhcraft.spaciouslib.utils.ReflectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class MaterialUtils {
    private static final InitialisationValidator validator = new InitialisationValidator();
    private static final List<Material> SKULL_TYPES = new ArrayList<>();
    private static final List<Material> ARMOR_TYPES = new ArrayList<>();
    private static final List<Material> ORE_TYPES = new ArrayList<>();
    private static final List<Material> BOAT_TYPES = new ArrayList<>();
    private static final List<Material> BUTTON_TYPES = new ArrayList<>();
    private static final List<Material> DOOR_TYPES = new ArrayList<>();
    private static final List<Material> FENCE_TYPES = new ArrayList<>();
    private static final List<Material> FENCE_GATE_TYPES = new ArrayList<>();
    private static final List<Material> LEAVES_TYPES = new ArrayList<>();
    private static final List<Material> LOG_TYPES = new ArrayList<>();
    private static final List<Material> STRIPPED_LOG_TYPES = new ArrayList<>();
    private static final List<Material> PLANKS_TYPES = new ArrayList<>();
    private static final List<Material> PRESSURE_PLATE_TYPES = new ArrayList<>();
    private static final List<Material> SAPLING_TYPES = new ArrayList<>();
    private static final List<Material> SLAB_TYPES = new ArrayList<>();
    private static final List<Material> STAIRS_TYPES = new ArrayList<>();
    private static final List<Material> TRAPDOOR_TYPES = new ArrayList<>();
    private static final List<Material> WOOD_TYPES = new ArrayList<>();
    private static final List<Material> STRIPPED_WOOD_TYPES = new ArrayList<>();
    private static final List<Material> BANNER_TYPES = new ArrayList<>();
    private static final List<Material> BED_TYPES = new ArrayList<>();
    private static final List<Material> CARPET_TYPES = new ArrayList<>();
    private static final List<Material> CONCRETE_TYPES = new ArrayList<>();
    private static final List<Material> CONCRETE_POWDER_TYPES = new ArrayList<>();
    private static final List<Material> GLAZED_TERRACOTTA_TYPES = new ArrayList<>();
    private static final List<Material> SHULKER_BOX_TYPES = new ArrayList<>();
    private static final List<Material> STAINED_GLASS_TYPES = new ArrayList<>();
    private static final List<Material> STAINED_GLASS_PANE_TYPES = new ArrayList<>();
    private static final List<Material> TERRACOTTA_TYPES = new ArrayList<>();
    private static final List<Material> WALL_BANNER_TYPES = new ArrayList<>();
    private static final List<Material> WOOL_TYPES = new ArrayList<>();
    private static final List<Material> MUSIC_DISC_TYPES = new ArrayList<>();
    private static final List<Material> BUSH_TYPES = new ArrayList<>();
    private static final List<Material> DYE_TYPES = new ArrayList<>();
    private static final List<Material> CORAL_TYPES = new ArrayList<>();
    private static final List<Material> CORAL_BLOCK_TYPES = new ArrayList<>();
    private static final List<Material> CORAL_FAN_TYPES = new ArrayList<>();
    private static final List<Material> CORAL_WALL_FAN_TYPES = new ArrayList<>();
    private static final List<Material> DEAD_CORAL_TYPES = new ArrayList<>();
    private static final List<Material> DEAD_CORAL_BLOCK_TYPES = new ArrayList<>();
    private static final List<Material> DEAD_CORAL_FAN_TYPES = new ArrayList<>();
    private static final List<Material> DEAD_CORAL_WALL_FAN_TYPES = new ArrayList<>();
    private static final List<Material> HELMET_TYPES = new ArrayList<>();
    private static final List<Material> CHESTPLATE_TYPES = new ArrayList<>();
    private static final List<Material> LEGGINGS_TYPES = new ArrayList<>();
    private static final List<Material> BOOTS_TYPES = new ArrayList<>();
    private static final List<Material> SWORD_TYPES = new ArrayList<>();
    private static final List<Material> SHOVEL_TYPES = new ArrayList<>();
    private static final List<Material> AXE_TYPES = new ArrayList<>();
    private static final List<Material> HOE_TYPES = new ArrayList<>();
    private static final List<Material> PICKAXE_TYPES = new ArrayList<>();

    /**
     * Initializes MaterialUtils
     */
    public static void init(){
        try {
            validator.validate();
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }
        if(GameVersion.is1_13Above()){
            // SKULL
            SKULL_TYPES.add(Material.CREEPER_HEAD);
            SKULL_TYPES.add(Material.DRAGON_HEAD);
            SKULL_TYPES.add(Material.PLAYER_HEAD);
            SKULL_TYPES.add(Material.ZOMBIE_HEAD);
            SKULL_TYPES.add(Material.SKELETON_SKULL);
            SKULL_TYPES.add(Material.SKELETON_WALL_SKULL);
            SKULL_TYPES.add(Material.WITHER_SKELETON_SKULL);
            SKULL_TYPES.add(Material.WITHER_SKELETON_WALL_SKULL);
            SKULL_TYPES.add(Material.LEGACY_SKULL);

            // ORE
            ORE_TYPES.add(Material.NETHER_QUARTZ_ORE);
            ORE_TYPES.add(Material.LEGACY_GOLD_ORE);
            ORE_TYPES.add(Material.LEGACY_IRON_ORE);
            ORE_TYPES.add(Material.LEGACY_COAL_ORE);
            ORE_TYPES.add(Material.LEGACY_LAPIS_ORE);
            ORE_TYPES.add(Material.LEGACY_DIAMOND_ORE);
            ORE_TYPES.add(Material.LEGACY_REDSTONE_ORE);
            ORE_TYPES.add(Material.LEGACY_GLOWING_REDSTONE_ORE);
            ORE_TYPES.add(Material.LEGACY_EMERALD_ORE);
            ORE_TYPES.add(Material.LEGACY_QUARTZ_ORE);

            // BOAT
            BOAT_TYPES.add(Material.ACACIA_BOAT);
            BOAT_TYPES.add(Material.BIRCH_BOAT);
            BOAT_TYPES.add(Material.DARK_OAK_BOAT);
            BOAT_TYPES.add(Material.JUNGLE_BOAT);
            BOAT_TYPES.add(Material.OAK_BOAT);
            BOAT_TYPES.add(Material.SPRUCE_BOAT);
            BOAT_TYPES.add(Material.LEGACY_BOAT);

            // BUTTON
            BUTTON_TYPES.add(Material.ACACIA_BUTTON);
            BUTTON_TYPES.add(Material.BIRCH_BUTTON);
            BUTTON_TYPES.add(Material.DARK_OAK_BUTTON);
            BUTTON_TYPES.add(Material.JUNGLE_BUTTON);
            BUTTON_TYPES.add(Material.OAK_BUTTON);
            BUTTON_TYPES.add(Material.SPRUCE_BUTTON);
            BUTTON_TYPES.add(Material.STONE_BUTTON);
            BUTTON_TYPES.add(Material.LEGACY_STONE_BUTTON);
            BUTTON_TYPES.add(Material.LEGACY_WOOD_BUTTON);

            // DOOR
            DOOR_TYPES.add(Material.OAK_DOOR);
            DOOR_TYPES.add(Material.LEGACY_WOODEN_DOOR);
            DOOR_TYPES.add(Material.LEGACY_SPRUCE_DOOR);
            DOOR_TYPES.add(Material.LEGACY_BIRCH_DOOR);
            DOOR_TYPES.add(Material.LEGACY_JUNGLE_DOOR);
            DOOR_TYPES.add(Material.LEGACY_ACACIA_DOOR);
            DOOR_TYPES.add(Material.LEGACY_DARK_OAK_DOOR);
            DOOR_TYPES.add(Material.LEGACY_WOOD_DOOR);
            DOOR_TYPES.add(Material.LEGACY_IRON_DOOR);

            // FENCE
            FENCE_TYPES.add(Material.NETHER_BRICK_FENCE);
            FENCE_TYPES.add(Material.OAK_FENCE);
            FENCE_TYPES.add(Material.IRON_BARS);
            FENCE_TYPES.add(Material.LEGACY_FENCE);
            FENCE_TYPES.add(Material.LEGACY_IRON_FENCE);
            FENCE_TYPES.add(Material.LEGACY_NETHER_FENCE);
            FENCE_TYPES.add(Material.LEGACY_SPRUCE_FENCE);
            FENCE_TYPES.add(Material.LEGACY_BIRCH_FENCE);
            FENCE_TYPES.add(Material.LEGACY_JUNGLE_FENCE);
            FENCE_TYPES.add(Material.LEGACY_DARK_OAK_FENCE);
            FENCE_TYPES.add(Material.LEGACY_ACACIA_FENCE);

            // FENCE_GATE
            FENCE_GATE_TYPES.add(Material.OAK_FENCE_GATE);
            FENCE_GATE_TYPES.add(Material.LEGACY_FENCE_GATE);
            FENCE_GATE_TYPES.add(Material.LEGACY_SPRUCE_FENCE_GATE);
            FENCE_GATE_TYPES.add(Material.LEGACY_BIRCH_FENCE_GATE);
            FENCE_GATE_TYPES.add(Material.LEGACY_JUNGLE_FENCE_GATE);
            FENCE_GATE_TYPES.add(Material.LEGACY_DARK_OAK_FENCE_GATE);
            FENCE_GATE_TYPES.add(Material.LEGACY_ACACIA_FENCE_GATE);

            // LEAVES
            LEAVES_TYPES.add(Material.ACACIA_LEAVES);
            LEAVES_TYPES.add(Material.BIRCH_LEAVES);
            LEAVES_TYPES.add(Material.DARK_OAK_LEAVES);
            LEAVES_TYPES.add(Material.JUNGLE_LEAVES);
            LEAVES_TYPES.add(Material.OAK_LEAVES);
            LEAVES_TYPES.add(Material.SPRUCE_LEAVES);
            LEAVES_TYPES.add(Material.LEGACY_LEAVES);

            // LOG
            LOG_TYPES.add(Material.ACACIA_LOG);
            LOG_TYPES.add(Material.BIRCH_LOG);
            LOG_TYPES.add(Material.DARK_OAK_LOG);
            LOG_TYPES.add(Material.JUNGLE_LOG);
            LOG_TYPES.add(Material.OAK_LOG);
            LOG_TYPES.add(Material.SPRUCE_LOG);
            LOG_TYPES.add(Material.LEGACY_LOG);

            // STRIPPED_LOG
            STRIPPED_LOG_TYPES.add(Material.STRIPPED_ACACIA_LOG);
            STRIPPED_LOG_TYPES.add(Material.STRIPPED_BIRCH_LOG);
            STRIPPED_LOG_TYPES.add(Material.STRIPPED_DARK_OAK_LOG);
            STRIPPED_LOG_TYPES.add(Material.STRIPPED_JUNGLE_LOG);
            STRIPPED_LOG_TYPES.add(Material.STRIPPED_OAK_LOG);
            STRIPPED_LOG_TYPES.add(Material.STRIPPED_SPRUCE_LOG);

            // PLANKS
            PLANKS_TYPES.add(Material.ACACIA_PLANKS);
            PLANKS_TYPES.add(Material.BIRCH_PLANKS);
            PLANKS_TYPES.add(Material.DARK_OAK_PLANKS);
            PLANKS_TYPES.add(Material.JUNGLE_PLANKS);
            PLANKS_TYPES.add(Material.OAK_PLANKS);
            PLANKS_TYPES.add(Material.SPRUCE_PLANKS);

            // PRESSURE_PLATE
            PRESSURE_PLATE_TYPES.add(Material.ACACIA_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.BIRCH_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.DARK_OAK_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.JUNGLE_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.OAK_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.SPRUCE_PRESSURE_PLATE);
            PRESSURE_PLATE_TYPES.add(Material.STONE_PRESSURE_PLATE);

            // SAPLING
            SAPLING_TYPES.add(Material.ACACIA_SAPLING);
            SAPLING_TYPES.add(Material.BIRCH_SAPLING);
            SAPLING_TYPES.add(Material.DARK_OAK_SAPLING);
            SAPLING_TYPES.add(Material.JUNGLE_SAPLING);
            SAPLING_TYPES.add(Material.OAK_SAPLING);
            SAPLING_TYPES.add(Material.SPRUCE_SAPLING);
            SAPLING_TYPES.add(Material.LEGACY_SAPLING);

            // SLAB
            SLAB_TYPES.add(Material.ACACIA_SLAB);
            SLAB_TYPES.add(Material.BIRCH_SLAB);
            SLAB_TYPES.add(Material.BRICK_SLAB);
            SLAB_TYPES.add(Material.COBBLESTONE_SLAB);
            SLAB_TYPES.add(Material.DARK_OAK_SLAB);
            SLAB_TYPES.add(Material.DARK_PRISMARINE_SLAB);
            SLAB_TYPES.add(Material.JUNGLE_SLAB);
            SLAB_TYPES.add(Material.NETHER_BRICK_SLAB);
            SLAB_TYPES.add(Material.OAK_SLAB);
            SLAB_TYPES.add(Material.PETRIFIED_OAK_SLAB);
            SLAB_TYPES.add(Material.PRISMARINE_BRICK_SLAB);
            SLAB_TYPES.add(Material.PRISMARINE_SLAB);
            SLAB_TYPES.add(Material.PURPUR_SLAB);
            SLAB_TYPES.add(Material.QUARTZ_SLAB);
            SLAB_TYPES.add(Material.RED_SANDSTONE_SLAB);
            SLAB_TYPES.add(Material.SANDSTONE_SLAB);
            SLAB_TYPES.add(Material.SPRUCE_SLAB);
            SLAB_TYPES.add(Material.STONE_BRICK_SLAB);
            SLAB_TYPES.add(Material.STONE_SLAB);
            SLAB_TYPES.add(Material.LEGACY_PURPUR_DOUBLE_SLAB);
            SLAB_TYPES.add(Material.LEGACY_PURPUR_SLAB);
			SLAB_TYPES.add(Material.LEGACY_DOUBLE_STONE_SLAB2);
            SLAB_TYPES.add(Material.LEGACY_STONE_SLAB2);
            SLAB_TYPES.add(Material.LEGACY_STEP);

            // STAIRS
            STAIRS_TYPES.add(Material.DARK_PRISMARINE_STAIRS);
            STAIRS_TYPES.add(Material.JUNGLE_STAIRS);
            STAIRS_TYPES.add(Material.NETHER_BRICK_STAIRS);
            STAIRS_TYPES.add(Material.OAK_STAIRS);
            STAIRS_TYPES.add(Material.BIRCH_STAIRS);
            STAIRS_TYPES.add(Material.PRISMARINE_BRICK_STAIRS);
            STAIRS_TYPES.add(Material.PRISMARINE_STAIRS);
            STAIRS_TYPES.add(Material.SPRUCE_STAIRS);
            STAIRS_TYPES.add(Material.STONE_BRICK_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_WOOD_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_COBBLESTONE_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_BRICK_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_SMOOTH_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_NETHER_BRICK_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_SANDSTONE_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_SPRUCE_WOOD_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_BIRCH_WOOD_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_JUNGLE_WOOD_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_QUARTZ_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_ACACIA_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_DARK_OAK_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_RED_SANDSTONE_STAIRS);
            STAIRS_TYPES.add(Material.LEGACY_PURPUR_STAIRS);

            // TRAPDOOR
            TRAPDOOR_TYPES.add(Material.ACACIA_TRAPDOOR);
            TRAPDOOR_TYPES.add(Material.BIRCH_TRAPDOOR);
            TRAPDOOR_TYPES.add(Material.DARK_OAK_TRAPDOOR);
            TRAPDOOR_TYPES.add(Material.IRON_TRAPDOOR);
            TRAPDOOR_TYPES.add(Material.JUNGLE_TRAPDOOR);
            TRAPDOOR_TYPES.add(Material.OAK_TRAPDOOR);
            TRAPDOOR_TYPES.add(Material.SPRUCE_TRAPDOOR);
            TRAPDOOR_TYPES.add(Material.LEGACY_TRAP_DOOR);
            TRAPDOOR_TYPES.add(Material.LEGACY_IRON_TRAPDOOR);

            // WOOD
            WOOD_TYPES.add(Material.ACACIA_WOOD);
            WOOD_TYPES.add(Material.BIRCH_WOOD);
            WOOD_TYPES.add(Material.DARK_OAK_WOOD);
            WOOD_TYPES.add(Material.JUNGLE_WOOD);
            WOOD_TYPES.add(Material.OAK_WOOD);
            WOOD_TYPES.add(Material.SPRUCE_WOOD);
            WOOD_TYPES.add(Material.LEGACY_WOOD);

            // STRIPPED_WOOD
            STRIPPED_WOOD_TYPES.add(Material.STRIPPED_ACACIA_WOOD);
            STRIPPED_WOOD_TYPES.add(Material.STRIPPED_BIRCH_WOOD);
            STRIPPED_WOOD_TYPES.add(Material.STRIPPED_DARK_OAK_WOOD);
            STRIPPED_WOOD_TYPES.add(Material.STRIPPED_JUNGLE_WOOD);
            STRIPPED_WOOD_TYPES.add(Material.STRIPPED_OAK_WOOD);
            STRIPPED_WOOD_TYPES.add(Material.STRIPPED_SPRUCE_WOOD);

            // BANNER
            BANNER_TYPES.add(Material.BLACK_BANNER);
            BANNER_TYPES.add(Material.BLACK_WALL_BANNER);
            BANNER_TYPES.add(Material.BLUE_BANNER);
            BANNER_TYPES.add(Material.BLUE_WALL_BANNER);
            BANNER_TYPES.add(Material.BROWN_BANNER);
            BANNER_TYPES.add(Material.BROWN_WALL_BANNER);
            BANNER_TYPES.add(Material.CYAN_BANNER);
            BANNER_TYPES.add(Material.CYAN_WALL_BANNER);
            BANNER_TYPES.add(Material.GRAY_BANNER);
            BANNER_TYPES.add(Material.GRAY_WALL_BANNER);
            BANNER_TYPES.add(Material.GREEN_BANNER);
            BANNER_TYPES.add(Material.GREEN_WALL_BANNER);
            BANNER_TYPES.add(Material.LIGHT_BLUE_BANNER);
            BANNER_TYPES.add(Material.LIGHT_BLUE_WALL_BANNER);
            BANNER_TYPES.add(Material.LIGHT_GRAY_BANNER);
            BANNER_TYPES.add(Material.LIGHT_GRAY_WALL_BANNER);
            BANNER_TYPES.add(Material.LIME_BANNER);
            BANNER_TYPES.add(Material.LIME_WALL_BANNER);
            BANNER_TYPES.add(Material.MAGENTA_BANNER);
            BANNER_TYPES.add(Material.MAGENTA_WALL_BANNER);
            BANNER_TYPES.add(Material.ORANGE_BANNER);
            BANNER_TYPES.add(Material.ORANGE_WALL_BANNER);
            BANNER_TYPES.add(Material.PINK_BANNER);
            BANNER_TYPES.add(Material.PINK_WALL_BANNER);
            BANNER_TYPES.add(Material.PURPLE_BANNER);
            BANNER_TYPES.add(Material.PURPLE_WALL_BANNER);
            BANNER_TYPES.add(Material.RED_BANNER);
            BANNER_TYPES.add(Material.RED_WALL_BANNER);
            BANNER_TYPES.add(Material.WHITE_BANNER);
            BANNER_TYPES.add(Material.WHITE_WALL_BANNER);
            BANNER_TYPES.add(Material.YELLOW_BANNER);
            BANNER_TYPES.add(Material.YELLOW_WALL_BANNER);
            BANNER_TYPES.add(Material.LEGACY_STANDING_BANNER);
            BANNER_TYPES.add(Material.LEGACY_WALL_BANNER);
            BANNER_TYPES.add(Material.LEGACY_BANNER);

            // BED
            BED_TYPES.add(Material.BLACK_BED);
            BED_TYPES.add(Material.BLUE_BED);
            BED_TYPES.add(Material.BROWN_BED);
            BED_TYPES.add(Material.CYAN_BED);
            BED_TYPES.add(Material.GRAY_BED);
            BED_TYPES.add(Material.GREEN_BED);
            BED_TYPES.add(Material.LIGHT_BLUE_BED);
            BED_TYPES.add(Material.LIGHT_GRAY_BED);
            BED_TYPES.add(Material.LIME_BED);
            BED_TYPES.add(Material.MAGENTA_BED);
            BED_TYPES.add(Material.ORANGE_BED);
            BED_TYPES.add(Material.PINK_BED);
            BED_TYPES.add(Material.PURPLE_BED);
            BED_TYPES.add(Material.RED_BED);
            BED_TYPES.add(Material.WHITE_BED);
            BED_TYPES.add(Material.YELLOW_BED);
            BED_TYPES.add(Material.LEGACY_BED);

            // CARPET
            CARPET_TYPES.add(Material.BLACK_CARPET);
            CARPET_TYPES.add(Material.BLUE_CARPET);
            CARPET_TYPES.add(Material.BROWN_CARPET);
            CARPET_TYPES.add(Material.CYAN_CARPET);
            CARPET_TYPES.add(Material.GRAY_CARPET);
            CARPET_TYPES.add(Material.GREEN_CARPET);
            CARPET_TYPES.add(Material.LIGHT_BLUE_CARPET);
            CARPET_TYPES.add(Material.LIGHT_GRAY_CARPET);
            CARPET_TYPES.add(Material.LIME_CARPET);
            CARPET_TYPES.add(Material.MAGENTA_CARPET);
            CARPET_TYPES.add(Material.ORANGE_CARPET);
            CARPET_TYPES.add(Material.PINK_CARPET);
            CARPET_TYPES.add(Material.PURPLE_CARPET);
            CARPET_TYPES.add(Material.RED_CARPET);
            CARPET_TYPES.add(Material.WHITE_CARPET);
            CARPET_TYPES.add(Material.YELLOW_CARPET);
            CARPET_TYPES.add(Material.LEGACY_CARPET);

            // CONCRETE
            CONCRETE_TYPES.add(Material.BLACK_CONCRETE);
            CONCRETE_TYPES.add(Material.BLUE_CONCRETE);
            CONCRETE_TYPES.add(Material.BROWN_CONCRETE);
            CONCRETE_TYPES.add(Material.CYAN_CONCRETE);
            CONCRETE_TYPES.add(Material.GRAY_CONCRETE);
            CONCRETE_TYPES.add(Material.GREEN_CONCRETE);
            CONCRETE_TYPES.add(Material.LIGHT_BLUE_CONCRETE);
            CONCRETE_TYPES.add(Material.LIGHT_GRAY_CONCRETE);
            CONCRETE_TYPES.add(Material.LIME_CONCRETE);
            CONCRETE_TYPES.add(Material.MAGENTA_CONCRETE);
            CONCRETE_TYPES.add(Material.ORANGE_CONCRETE);
            CONCRETE_TYPES.add(Material.PINK_CONCRETE);
            CONCRETE_TYPES.add(Material.PURPLE_CONCRETE);
            CONCRETE_TYPES.add(Material.RED_CONCRETE);
            CONCRETE_TYPES.add(Material.WHITE_CONCRETE);
            CONCRETE_TYPES.add(Material.YELLOW_CONCRETE);
            CONCRETE_TYPES.add(Material.LEGACY_CONCRETE);

            // CONCRETE_POWDER
            CONCRETE_POWDER_TYPES.add(Material.BLACK_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.BLUE_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.BROWN_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.CYAN_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.GRAY_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.GREEN_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.LIGHT_BLUE_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.LIGHT_GRAY_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.LIME_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.MAGENTA_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.ORANGE_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.PINK_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.PURPLE_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.RED_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.WHITE_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.YELLOW_CONCRETE_POWDER);
            CONCRETE_POWDER_TYPES.add(Material.LEGACY_CONCRETE_POWDER);

            // GLAZED_TERRACOTTA
            GLAZED_TERRACOTTA_TYPES.add(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
			
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_WHITE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_ORANGE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_MAGENTA_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_LIGHT_BLUE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_YELLOW_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_LIME_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_PINK_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_GRAY_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_SILVER_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_CYAN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_PURPLE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_BLUE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_BROWN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_GREEN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_RED_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_BLACK_GLAZED_TERRACOTTA);

            // SHULKER_BOX
            SHULKER_BOX_TYPES.add(Material.SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LIGHT_GRAY_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_WHITE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_ORANGE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_MAGENTA_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_LIGHT_BLUE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_YELLOW_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_LIME_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_PINK_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_GRAY_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_SILVER_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_CYAN_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_PURPLE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_BLUE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_BROWN_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_GREEN_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_RED_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LEGACY_BLACK_SHULKER_BOX);

            // STAINED_GLASS
            STAINED_GLASS_TYPES.add(Material.BLACK_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.BLUE_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.BROWN_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.CYAN_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.GRAY_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.GREEN_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.LIGHT_BLUE_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.LIGHT_GRAY_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.LIME_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.MAGENTA_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.ORANGE_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.PINK_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.PURPLE_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.RED_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.WHITE_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.YELLOW_STAINED_GLASS);
            STAINED_GLASS_TYPES.add(Material.LEGACY_STAINED_GLASS);

            // STAINED_GLASS_PANE
            STAINED_GLASS_PANE_TYPES.add(Material.BLACK_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.BLUE_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.BROWN_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.CYAN_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.GRAY_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.GREEN_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.LIME_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.MAGENTA_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.ORANGE_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.PINK_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.PURPLE_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.RED_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.WHITE_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.YELLOW_STAINED_GLASS_PANE);
            STAINED_GLASS_PANE_TYPES.add(Material.LEGACY_STAINED_GLASS_PANE);

            // TERRACOTTA
            TERRACOTTA_TYPES.add(Material.LIGHT_GRAY_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.BLACK_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.BLUE_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.BROWN_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.CYAN_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.GRAY_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.GREEN_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.LIGHT_BLUE_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.LIME_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.MAGENTA_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.ORANGE_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.PINK_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.PURPLE_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.RED_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.WHITE_TERRACOTTA);
            TERRACOTTA_TYPES.add(Material.YELLOW_TERRACOTTA);
			
			// GLAZED_TERRACOTTA
            GLAZED_TERRACOTTA_TYPES.add(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_WHITE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_ORANGE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_MAGENTA_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_LIGHT_BLUE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_YELLOW_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_LIME_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_PINK_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_GRAY_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_SILVER_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_CYAN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_PURPLE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_BLUE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_BROWN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_GREEN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_RED_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LEGACY_BLACK_GLAZED_TERRACOTTA);

            // WALL_BANNER
            WALL_BANNER_TYPES.add(Material.BLACK_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.BLUE_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.BROWN_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.CYAN_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.GRAY_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.GREEN_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.LIGHT_BLUE_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.LIGHT_GRAY_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.LIME_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.MAGENTA_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.ORANGE_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.PINK_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.PURPLE_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.RED_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.WHITE_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.YELLOW_WALL_BANNER);
            WALL_BANNER_TYPES.add(Material.LEGACY_WALL_BANNER);

            // WOOL
            WOOL_TYPES.add(Material.BLACK_WOOL);
            WOOL_TYPES.add(Material.BLUE_WOOL);
            WOOL_TYPES.add(Material.BROWN_WOOL);
            WOOL_TYPES.add(Material.CYAN_WOOL);
            WOOL_TYPES.add(Material.GRAY_WOOL);
            WOOL_TYPES.add(Material.GREEN_WOOL);
            WOOL_TYPES.add(Material.LIGHT_BLUE_WOOL);
            WOOL_TYPES.add(Material.LIGHT_GRAY_WOOL);
            WOOL_TYPES.add(Material.LIME_WOOL);
            WOOL_TYPES.add(Material.MAGENTA_WOOL);
            WOOL_TYPES.add(Material.ORANGE_WOOL);
            WOOL_TYPES.add(Material.PINK_WOOL);
            WOOL_TYPES.add(Material.PURPLE_WOOL);
            WOOL_TYPES.add(Material.RED_WOOL);
            WOOL_TYPES.add(Material.WHITE_WOOL);
            WOOL_TYPES.add(Material.YELLOW_WOOL);
            WOOL_TYPES.add(Material.LEGACY_WOOL);

            // MUSIC_DISC
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_11);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_13);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_BLOCKS);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_CAT);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_CHIRP);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_FAR);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_MALL);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_MELLOHI);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_STAL);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_STRAD);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_WAIT);
            MUSIC_DISC_TYPES.add(Material.MUSIC_DISC_WARD);

            // BUSH
            BUSH_TYPES.add(Material.POTTED_DEAD_BUSH);
            BUSH_TYPES.add(Material.ROSE_BUSH);
            BUSH_TYPES.add(Material.LEGACY_DEAD_BUSH);

            // DYE
            DYE_TYPES.add(Material.CYAN_DYE);
            DYE_TYPES.add(Material.GRAY_DYE);
            DYE_TYPES.add(Material.LIGHT_BLUE_DYE);
            DYE_TYPES.add(Material.LIGHT_GRAY_DYE);
            DYE_TYPES.add(Material.LIME_DYE);
            DYE_TYPES.add(Material.MAGENTA_DYE);
            DYE_TYPES.add(Material.ORANGE_DYE);
            DYE_TYPES.add(Material.PINK_DYE);
            DYE_TYPES.add(Material.PURPLE_DYE);

            // CORAL
            CORAL_TYPES.add(Material.BRAIN_CORAL);
            CORAL_TYPES.add(Material.BUBBLE_CORAL);
            CORAL_TYPES.add(Material.FIRE_CORAL);
            CORAL_TYPES.add(Material.HORN_CORAL);
            CORAL_TYPES.add(Material.TUBE_CORAL);

            // CORAL_BLOCK
            CORAL_BLOCK_TYPES.add(Material.BRAIN_CORAL_BLOCK);
            CORAL_BLOCK_TYPES.add(Material.BUBBLE_CORAL_BLOCK);
            CORAL_BLOCK_TYPES.add(Material.FIRE_CORAL_BLOCK);
            CORAL_BLOCK_TYPES.add(Material.HORN_CORAL_BLOCK);
            CORAL_BLOCK_TYPES.add(Material.TUBE_CORAL_BLOCK);

            // CORAL_FAN
            CORAL_FAN_TYPES.add(Material.BRAIN_CORAL_FAN);
            CORAL_FAN_TYPES.add(Material.BUBBLE_CORAL_FAN);
            CORAL_FAN_TYPES.add(Material.FIRE_CORAL_FAN);
            CORAL_FAN_TYPES.add(Material.HORN_CORAL_FAN);
            CORAL_FAN_TYPES.add(Material.TUBE_CORAL_FAN);

            // CORAL_WALL_FAN
            CORAL_WALL_FAN_TYPES.add(Material.BRAIN_CORAL_WALL_FAN);
            CORAL_WALL_FAN_TYPES.add(Material.BUBBLE_CORAL_WALL_FAN);
            CORAL_WALL_FAN_TYPES.add(Material.FIRE_CORAL_WALL_FAN);
            CORAL_WALL_FAN_TYPES.add(Material.HORN_CORAL_WALL_FAN);
            CORAL_WALL_FAN_TYPES.add(Material.TUBE_CORAL_WALL_FAN);

            // DEAD_CORAL
            DEAD_CORAL_TYPES.add(Material.DEAD_BRAIN_CORAL);
            DEAD_CORAL_TYPES.add(Material.DEAD_BUBBLE_CORAL);
            DEAD_CORAL_TYPES.add(Material.DEAD_FIRE_CORAL);
            DEAD_CORAL_TYPES.add(Material.DEAD_HORN_CORAL);
            DEAD_CORAL_TYPES.add(Material.DEAD_TUBE_CORAL);

            // DEAD_CORAL_BLOCK
            DEAD_CORAL_BLOCK_TYPES.add(Material.DEAD_BRAIN_CORAL_BLOCK);
            DEAD_CORAL_BLOCK_TYPES.add(Material.DEAD_BUBBLE_CORAL_BLOCK);
            DEAD_CORAL_BLOCK_TYPES.add(Material.DEAD_FIRE_CORAL_BLOCK);
            DEAD_CORAL_BLOCK_TYPES.add(Material.DEAD_HORN_CORAL_BLOCK);
            DEAD_CORAL_BLOCK_TYPES.add(Material.DEAD_TUBE_CORAL_BLOCK);

            // CORAL_FAN
            DEAD_CORAL_FAN_TYPES.add(Material.DEAD_BRAIN_CORAL_FAN);
            DEAD_CORAL_FAN_TYPES.add(Material.DEAD_BUBBLE_CORAL_FAN);
            DEAD_CORAL_FAN_TYPES.add(Material.DEAD_FIRE_CORAL_FAN);
            DEAD_CORAL_FAN_TYPES.add(Material.DEAD_HORN_CORAL_FAN);
            DEAD_CORAL_FAN_TYPES.add(Material.DEAD_TUBE_CORAL_FAN);

            // CORAL_WALL_FAN
            DEAD_CORAL_WALL_FAN_TYPES.add(Material.DEAD_BRAIN_CORAL_WALL_FAN);
            DEAD_CORAL_WALL_FAN_TYPES.add(Material.DEAD_BUBBLE_CORAL_WALL_FAN);
            DEAD_CORAL_WALL_FAN_TYPES.add(Material.DEAD_FIRE_CORAL_WALL_FAN);
            DEAD_CORAL_WALL_FAN_TYPES.add(Material.DEAD_HORN_CORAL_WALL_FAN);
            DEAD_CORAL_WALL_FAN_TYPES.add(Material.DEAD_TUBE_CORAL_WALL_FAN);

            // HELMET
            HELMET_TYPES.add(Material.GOLDEN_HELMET);

            // CHESTPLATE
            CHESTPLATE_TYPES.add(Material.GOLDEN_CHESTPLATE);

            // LEGGINGS
            LEGGINGS_TYPES.add(Material.GOLDEN_LEGGINGS);

            // BOOTS
            BOOTS_TYPES.add(Material.GOLDEN_BOOTS);
			
			// SHOVEL
			SHOVEL_TYPES.add(Material.IRON_SHOVEL);
			SHOVEL_TYPES.add(Material.WOODEN_SHOVEL);
			SHOVEL_TYPES.add(Material.STONE_SHOVEL);
			SHOVEL_TYPES.add(Material.DIAMOND_SHOVEL);
			SHOVEL_TYPES.add(Material.GOLDEN_SHOVEL);
			
			// SWORD
			SWORD_TYPES.add(Material.GOLDEN_SWORD);
			SWORD_TYPES.add(Material.WOODEN_SWORD);

			// AXE
			AXE_TYPES.add(Material.GOLDEN_AXE);
			AXE_TYPES.add(Material.WOODEN_AXE);

			// PICKAXE
			PICKAXE_TYPES.add(Material.GOLDEN_PICKAXE);
			PICKAXE_TYPES.add(Material.WOODEN_PICKAXE);

			// HOE
			HOE_TYPES.add(Material.GOLDEN_HOE);
			HOE_TYPES.add(Material.WOODEN_HOE);
        } else {
            // SKULL
            SKULL_TYPES.add(Material.valueOf("SKULL"));
            SKULL_TYPES.add(Material.valueOf("SKULL_ITEM"));

            // ORE
            ORE_TYPES.add(Material.valueOf("GLOWING_REDSTONE_ORE"));
            ORE_TYPES.add(Material.valueOf("QUARTZ_ORE"));

            // BOAT
            if(GameVersion.is1_9Above()) {
                BOAT_TYPES.add(Material.valueOf("BOAT_SPRUCE"));
                BOAT_TYPES.add(Material.valueOf("BOAT_BIRCH"));
                BOAT_TYPES.add(Material.valueOf("BOAT_JUNGLE"));
                BOAT_TYPES.add(Material.valueOf("BOAT_ACACIA"));
                BOAT_TYPES.add(Material.valueOf("BOAT_DARK_OAK"));
            }
            BOAT_TYPES.add(Material.valueOf("BOAT"));

            // BUTTON
            BUTTON_TYPES.add(Material.valueOf("STONE_BUTTON"));
            BUTTON_TYPES.add(Material.valueOf("WOOD_BUTTON"));

            // DOOR
            DOOR_TYPES.add(Material.valueOf("WOODEN_DOOR"));
            DOOR_TYPES.add(Material.valueOf("WOOD_DOOR"));

            // FENCE
            FENCE_TYPES.add(Material.valueOf("FENCE"));
            FENCE_TYPES.add(Material.valueOf("IRON_FENCE"));
            FENCE_TYPES.add(Material.valueOf("NETHER_FENCE"));

            // FENCE_GATE
            FENCE_GATE_TYPES.add(Material.valueOf("FENCE_GATE"));

            // LEAVES
            LEAVES_TYPES.add(Material.valueOf("LEAVES"));
            LEAVES_TYPES.add(Material.valueOf("LEAVES_2"));

            // LOG
            LOG_TYPES.add(Material.valueOf("LOG"));
            LOG_TYPES.add(Material.valueOf("LOG_2"));

            // PRESSURE_PLATE
            PRESSURE_PLATE_TYPES.add(Material.valueOf("IRON_PLATE"));
            PRESSURE_PLATE_TYPES.add(Material.valueOf("GOLD_PLATE"));
            PRESSURE_PLATE_TYPES.add(Material.valueOf("STONE_PLATE"));
            PRESSURE_PLATE_TYPES.add(Material.valueOf("WOOD_PLATE"));

            // SAPLING
            SAPLING_TYPES.add(Material.valueOf("SAPLING"));

            // SLAB
            if(GameVersion.is1_9Above()) {
                SLAB_TYPES.add(Material.valueOf("PURPUR_DOUBLE_SLAB"));
                SLAB_TYPES.add(Material.valueOf("PURPUR_SLAB"));
            }
			SLAB_TYPES.add(Material.valueOf("DOUBLE_STONE_SLAB2"));
            SLAB_TYPES.add(Material.valueOf("STONE_SLAB2"));
            SLAB_TYPES.add(Material.valueOf("STEP"));

            // STAIRS
            STAIRS_TYPES.add(Material.valueOf("WOOD_STAIRS"));
            STAIRS_TYPES.add(Material.valueOf("SMOOTH_STAIRS"));
            STAIRS_TYPES.add(Material.valueOf("NETHER_BRICK_STAIRS"));
            STAIRS_TYPES.add(Material.valueOf("SPRUCE_WOOD_STAIRS"));
            STAIRS_TYPES.add(Material.valueOf("BIRCH_WOOD_STAIRS"));
            STAIRS_TYPES.add(Material.valueOf("JUNGLE_WOOD_STAIRS"));

            // TRAPDOOR
            TRAPDOOR_TYPES.add(Material.valueOf("TRAP_DOOR"));
            TRAPDOOR_TYPES.add(Material.valueOf("IRON_TRAPDOOR"));
			
            // WOOD
            WOOD_TYPES.add(Material.valueOf("WOOD"));

            // BANNER
            BANNER_TYPES.add(Material.valueOf("STANDING_BANNER"));
            BANNER_TYPES.add(Material.valueOf("WALL_BANNER"));
            BANNER_TYPES.add(Material.valueOf("BANNER"));

            // BED
            BED_TYPES.add(Material.valueOf("BED_BLOCK"));
            BED_TYPES.add(Material.valueOf("BED"));

            // CARPET
            CARPET_TYPES.add(Material.valueOf("CARPET"));

            if(GameVersion.is1_12Above()) {
                // CONCRETE
                CONCRETE_TYPES.add(Material.valueOf("CONCRETE"));

                // CONCRETE_POWDER
                CONCRETE_POWDER_TYPES.add(Material.valueOf("CONCRETE_POWDER"));

                // TERRACOTTA
                TERRACOTTA_TYPES.add(Material.valueOf("HARD_CLAY"));
            }

            // STAINED_GLASS
            STAINED_GLASS_TYPES.add(Material.valueOf("STAINED_GLASS"));

            // STAINED_GLASS_PANE
            STAINED_GLASS_PANE_TYPES.add(Material.valueOf("STAINED_GLASS_PANE"));

            // WALL_BANNER
            WALL_BANNER_TYPES.add(Material.valueOf("WALL_BANNER"));

            // WOOL
            WOOL_TYPES.add(Material.valueOf("WOOL"));

            // MUSIC_DISC
            MUSIC_DISC_TYPES.add(Material.valueOf("GOLD_RECORD"));
            MUSIC_DISC_TYPES.add(Material.valueOf("GREEN_RECORD"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_3"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_4"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_5"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_6"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_7"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_8"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_9"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_10"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_11"));
            MUSIC_DISC_TYPES.add(Material.valueOf("RECORD_12"));

            // DYE
            DYE_TYPES.add(Material.valueOf("INK_SACK"));

            // HELMET
            HELMET_TYPES.add(Material.valueOf("GOLD_HELMET"));

            // CHESTPLATE
            CHESTPLATE_TYPES.add(Material.valueOf("GOLD_CHESTPLATE"));

            // LEGGINGS
            LEGGINGS_TYPES.add(Material.valueOf("GOLD_LEGGINGS"));

            // BOOTS
            BOOTS_TYPES.add(Material.valueOf("GOLD_BOOTS"));

			// SHOVEL
			SHOVEL_TYPES.add(Material.valueOf("IRON_SPADE"));
			SHOVEL_TYPES.add(Material.valueOf("WOOD_SPADE"));
			SHOVEL_TYPES.add(Material.valueOf("STONE_SPADE"));
			SHOVEL_TYPES.add(Material.valueOf("DIAMOND_SPADE"));
			SHOVEL_TYPES.add(Material.valueOf("GOLD_SPADE"));
			
			// SWORD
			SWORD_TYPES.add(Material.valueOf("GOLD_SWORD"));
			SWORD_TYPES.add(Material.valueOf("WOOD_SWORD"));

			// AXE
			AXE_TYPES.add(Material.valueOf("GOLD_AXE"));
			AXE_TYPES.add(Material.valueOf("WOOD_AXE"));

			// PICKAXE
			PICKAXE_TYPES.add(Material.valueOf("GOLD_PICKAXE"));
			PICKAXE_TYPES.add(Material.valueOf("WOOD_PICKAXE"));

			// HOE
			HOE_TYPES.add(Material.valueOf("GOLD_HOE"));
			HOE_TYPES.add(Material.valueOf("WOOD_HOE"));
        }

        // ORE
        ORE_TYPES.add(Material.COAL_ORE);
        ORE_TYPES.add(Material.DIAMOND_ORE);
        ORE_TYPES.add(Material.EMERALD_ORE);
        ORE_TYPES.add(Material.GOLD_ORE);
        ORE_TYPES.add(Material.IRON_ORE);
        ORE_TYPES.add(Material.LAPIS_ORE);
        ORE_TYPES.add(Material.REDSTONE_ORE);

        // DOOR
        DOOR_TYPES.add(Material.ACACIA_DOOR);
        DOOR_TYPES.add(Material.BIRCH_DOOR);
        DOOR_TYPES.add(Material.DARK_OAK_DOOR);
        DOOR_TYPES.add(Material.IRON_DOOR);
        DOOR_TYPES.add(Material.JUNGLE_DOOR);
        DOOR_TYPES.add(Material.SPRUCE_DOOR);

        // FENCE
        FENCE_TYPES.add(Material.SPRUCE_FENCE);
        FENCE_TYPES.add(Material.ACACIA_FENCE);
        FENCE_TYPES.add(Material.BIRCH_FENCE);
        FENCE_TYPES.add(Material.DARK_OAK_FENCE);
        FENCE_TYPES.add(Material.JUNGLE_FENCE);

        // FENCE_GATE
        FENCE_GATE_TYPES.add(Material.ACACIA_FENCE_GATE);
        FENCE_GATE_TYPES.add(Material.BIRCH_FENCE_GATE);
        FENCE_GATE_TYPES.add(Material.DARK_OAK_FENCE_GATE);
        FENCE_GATE_TYPES.add(Material.JUNGLE_FENCE_GATE);
        FENCE_GATE_TYPES.add(Material.SPRUCE_FENCE_GATE);

        // STAIRS
        STAIRS_TYPES.add(Material.ACACIA_STAIRS);
        STAIRS_TYPES.add(Material.BRICK_STAIRS);
        STAIRS_TYPES.add(Material.COBBLESTONE_STAIRS);
        STAIRS_TYPES.add(Material.DARK_OAK_STAIRS);
        STAIRS_TYPES.add(Material.QUARTZ_STAIRS);
        STAIRS_TYPES.add(Material.RED_SANDSTONE_STAIRS);
        STAIRS_TYPES.add(Material.SANDSTONE_STAIRS);

        if(GameVersion.is1_12Above()) {
            // GLAZED_TERRACOTTA
            GLAZED_TERRACOTTA_TYPES.add(Material.BLUE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.BLACK_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.BROWN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.CYAN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.GRAY_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.GREEN_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.LIME_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.MAGENTA_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.ORANGE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.PINK_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.PURPLE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.RED_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.WHITE_GLAZED_TERRACOTTA);
            GLAZED_TERRACOTTA_TYPES.add(Material.YELLOW_GLAZED_TERRACOTTA);
        }

        if(GameVersion.is1_11Above()) {
            // SHULKER_BOX
            SHULKER_BOX_TYPES.add(Material.BLACK_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.BLUE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.BROWN_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.CYAN_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.GRAY_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.GREEN_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LIGHT_BLUE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.LIME_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.MAGENTA_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.ORANGE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.PINK_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.PURPLE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.RED_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.WHITE_SHULKER_BOX);
            SHULKER_BOX_TYPES.add(Material.YELLOW_SHULKER_BOX);
        }

        // BUSH
        BUSH_TYPES.add(Material.DEAD_BUSH);

        // HELMET
        HELMET_TYPES.add(Material.LEATHER_HELMET);
        HELMET_TYPES.add(Material.CHAINMAIL_HELMET);
        HELMET_TYPES.add(Material.IRON_HELMET);
        HELMET_TYPES.add(Material.DIAMOND_HELMET);

        // CHESTPLATE
        CHESTPLATE_TYPES.add(Material.LEATHER_CHESTPLATE);
        CHESTPLATE_TYPES.add(Material.CHAINMAIL_CHESTPLATE);
        CHESTPLATE_TYPES.add(Material.IRON_CHESTPLATE);
        CHESTPLATE_TYPES.add(Material.DIAMOND_CHESTPLATE);

        // LEGGINGS
        LEGGINGS_TYPES.add(Material.LEATHER_LEGGINGS);
        LEGGINGS_TYPES.add(Material.CHAINMAIL_LEGGINGS);
        LEGGINGS_TYPES.add(Material.IRON_LEGGINGS);
        LEGGINGS_TYPES.add(Material.DIAMOND_LEGGINGS);

        // BOOTS
        BOOTS_TYPES.add(Material.LEATHER_BOOTS);
        BOOTS_TYPES.add(Material.CHAINMAIL_BOOTS);
        BOOTS_TYPES.add(Material.IRON_BOOTS);
        BOOTS_TYPES.add(Material.DIAMOND_BOOTS);

		// SWORD
		SWORD_TYPES.add(Material.IRON_SWORD);
		SWORD_TYPES.add(Material.STONE_SWORD);
		SWORD_TYPES.add(Material.DIAMOND_SWORD);

		// AXE
		AXE_TYPES.add(Material.IRON_AXE);
		AXE_TYPES.add(Material.STONE_AXE);
		AXE_TYPES.add(Material.DIAMOND_AXE);

		// PICKAXE
		PICKAXE_TYPES.add(Material.IRON_PICKAXE);
		PICKAXE_TYPES.add(Material.STONE_PICKAXE);
		PICKAXE_TYPES.add(Material.DIAMOND_PICKAXE);

		// HOE
		HOE_TYPES.add(Material.STONE_HOE);
		HOE_TYPES.add(Material.IRON_HOE);
		HOE_TYPES.add(Material.DIAMOND_HOE);

        // ARMOR
        ARMOR_TYPES.addAll(HELMET_TYPES);
        ARMOR_TYPES.addAll(LEGGINGS_TYPES);
        ARMOR_TYPES.addAll(CHESTPLATE_TYPES);
        ARMOR_TYPES.addAll(BOOTS_TYPES);
		if(GameVersion.is1_9Above()) {
            // STAIRS
            STAIRS_TYPES.add(Material.PURPUR_STAIRS);

            // ARMOR
            ARMOR_TYPES.add(Material.ELYTRA);
        }
    }

    /**
     * Serializes the given material data to string
     * @param md MaterialData object
     * @return a string represents for the object
     */
    public static String materialData2Str(MaterialData md){
        return md.getItemType().toString()+":"+md.getData();
    }

    /**
     * Deserialize the given string to its material data
     * @param s a string represents for the object
     * @return the material data
     */
    public static MaterialData str2MaterialData(String s){
        if(s == null || s.equalsIgnoreCase("null")){
            return new MaterialData(Material.AIR);
        }
        String[] x = s.split(":");
        Material mt;
        if(!GameVersion.is1_13Above() && StringUtils.isNumeric(x[0])) {
            mt = (Material) ReflectionUtils.getStaticMethod("getMaterial",
                    Material.class, new Group<>(
                            new Class<?>[]{int.class},
                            new Object[]{CommonUtils.toInteger(x[0])}
                    ));
        } else {
            mt = Material.valueOf(x[0].toUpperCase());
        }
        if(x.length == 2) {
            return new MaterialData(mt, (byte) Integer.parseInt(x[1]));
        } else {
            return new MaterialData(mt, (byte) 0);
        }
    }

    /**
     * Get all material types related to skull
     * @return list of material types
     */
    public static List<Material> getSkullTypes(){
        return new ArrayList<>(SKULL_TYPES);
    }

    /**
     * Get all material types related to ore
     * @return list of material types
     */
    public static List<Material> getOreTypes(){
        return new ArrayList<>(ORE_TYPES);
    }

    /**
     * Get all material types related to boat
     * @return list of material types
     */
    public static List<Material> getBoatTypes(){
        return new ArrayList<>(BOAT_TYPES);
    }

    /**
     * Get all material types related to button
     * @return list of material types
     */
    public static List<Material> getButtonTypes(){
        return new ArrayList<>(BUTTON_TYPES);
    }

    /**
     * Get all material types related to door
     * @return list of material types
     */
    public static List<Material> getDoorTypes(){
        return new ArrayList<>(DOOR_TYPES);
    }

    /**
     * Get all material types related to fence
     * @return list of material types
     */
    public static List<Material> getFenceTypes(){
        return new ArrayList<>(FENCE_TYPES);
    }

    /**
     * Get all material types related to fence gate
     * @return list of material types
     */
    public static List<Material> getFenceGateTypes(){
        return new ArrayList<>(FENCE_GATE_TYPES);
    }

    /**
     * Get all material types related to leaves
     * @return list of material types
     */
    public static List<Material> getLeavesTypes(){
        return new ArrayList<>(LEAVES_TYPES);
    }

    /**
     * Get all material types related to log
     * @return list of material types
     */
    public static List<Material> getLogTypes(){
        return new ArrayList<>(LOG_TYPES);
    }

    /**
     * Get all material types related to stripped log
     * @return list of material types
     */
    public static List<Material> getStrippedLogTypes(){
        return new ArrayList<>(STRIPPED_LOG_TYPES);
    }

    /**
     * Get all material types related to planks
     * @return list of material types
     */
    public static List<Material> getPlanksTypes(){
        return new ArrayList<>(PLANKS_TYPES);
    }

    /**
     * Get all material types related to pressure plate
     * @return list of material types
     */
    public static List<Material> getPressurePlateTypes(){
        return new ArrayList<>(PRESSURE_PLATE_TYPES);
    }

    /**
     * Get all material types related to sapling
     * @return list of material types
     */
    public static List<Material> getSaplingTypes(){
        return new ArrayList<>(SAPLING_TYPES);
    }

    /**
     * Get all material types related to slab
     * @return list of material types
     */
    public static List<Material> getSlabTypes(){
        return new ArrayList<>(SLAB_TYPES);
    }

    /**
     * Get all material types related to stairs
     * @return list of material types
     */
    public static List<Material> getStairsTypes(){
        return new ArrayList<>(STAIRS_TYPES);
    }

    /**
     * Get all material types related to trapdoor
     * @return list of material types
     */
    public static List<Material> getTrapdoorTypes(){
        return new ArrayList<>(TRAPDOOR_TYPES);
    }

    /**
     * Get all material types related to wood
     * @return list of material types
     */
    public static List<Material> getWoodTypes(){
        return new ArrayList<>(WOOD_TYPES);
    }

    /**
     * Get all material types related to stripped wood
     * @return list of material types
     */
    public static List<Material> getStrippedWoodTypes(){
        return new ArrayList<>(STRIPPED_WOOD_TYPES);
    }

    /**
     * Get all material types related to banner
     * @return list of material types
     */
    public static List<Material> getBannerTypes(){
        return new ArrayList<>(BANNER_TYPES);
    }

    /**
     * Get all material types related to bed
     * @return list of material types
     */
    public static List<Material> getBedTypes(){
        return new ArrayList<>(BED_TYPES);
    }

    /**
     * Get all material types related to carpet
     * @return list of material types
     */
    public static List<Material> getCarpetTypes(){
        return new ArrayList<>(CARPET_TYPES);
    }

    /**
     * Get all material types related to concrete
     * @return list of material types
     */
    public static List<Material> getConcreteTypes(){
        return new ArrayList<>(CONCRETE_TYPES);
    }

    /**
     * Get all material types related to concrete powder
     * @return list of material types
     */
    public static List<Material> getConcretePowderTypes(){
        return new ArrayList<>(CONCRETE_POWDER_TYPES);
    }

    /**
     * Get all material types related to glazed terracotta
     * @return list of material types
     */
    public static List<Material> getGlazedTerracottaTypes(){
        return new ArrayList<>(GLAZED_TERRACOTTA_TYPES);
    }

    /**
     * Get all material types related to shulker box
     * @return list of material types
     */
    public static List<Material> getShulkerBoxTypes(){
        return new ArrayList<>(SHULKER_BOX_TYPES);
    }

    /**
     * Get all material types related to stained glass
     * @return list of material types
     */
    public static List<Material> getStainedGlassTypes(){
        return new ArrayList<>(STAINED_GLASS_TYPES);
    }

    /**
     * Get all material types related to stained glass pane
     * @return list of material types
     */
    public static List<Material> getStainedGlassPaneTypes(){
        return new ArrayList<>(STAINED_GLASS_PANE_TYPES);
    }

    /**
     * Get all material types related to terracotta
     * @return list of material types
     */
    public static List<Material> getTerracottaTypes(){
        return new ArrayList<>(TERRACOTTA_TYPES);
    }

    /**
     * Get all material types related to wall banner
     * @return list of material types
     */
    public static List<Material> getWallBannerTypes(){
        return new ArrayList<>(WALL_BANNER_TYPES);
    }

    /**
     * Get all material types related to wool
     * @return list of material types
     */
    public static List<Material> getWoolTypes(){
        return new ArrayList<>(WOOL_TYPES);
    }

    /**
     * Get all material types related to music disc
     * @return list of material types
     */
    public static List<Material> getMusicDiscTypes(){
        return new ArrayList<>(MUSIC_DISC_TYPES);
    }

    /**
     * Get all material types related to bush
     * @return list of material types
     */
    public static List<Material> getBushTypes(){
        return new ArrayList<>(BUSH_TYPES);
    }

    /**
     * Get all material types related to dye
     * @return list of material types
     */
    public static List<Material> getDyeTypes(){
        return new ArrayList<>(DYE_TYPES);
    }

    /**
     * Get all material types related to coral
     * @return list of material types
     */
    public static List<Material> getCoralTypes(){
        return new ArrayList<>(CORAL_TYPES);
    }

    /**
     * Get all material types related to coral block
     * @return list of material types
     */
    public static List<Material> getCoralBlockTypes(){
        return new ArrayList<>(CORAL_BLOCK_TYPES);
    }

    /**
     * Get all material types related to coral fan
     * @return list of material types
     */
    public static List<Material> getCoralFanTypes(){
        return new ArrayList<>(CORAL_FAN_TYPES);
    }

    /**
     * Get all material types related to coral wall fan
     * @return list of material types
     */
    public static List<Material> getCoralWallFanTypes(){
        return new ArrayList<>(CORAL_WALL_FAN_TYPES);
    }

    /**
     * Get all material types related to dead coral
     * @return list of material types
     */
    public static List<Material> getDeadCoralTypes(){
        return new ArrayList<>(DEAD_CORAL_TYPES);
    }

    /**
     * Get all material types related to dead coral block
     * @return list of material types
     */
    public static List<Material> getDeadCoralBlockTypes(){
        return new ArrayList<>(DEAD_CORAL_BLOCK_TYPES);
    }

    /**
     * Get all material types related to dead coral fan
     * @return list of material types
     */
    public static List<Material> getDeadCoralFanTypes(){
        return new ArrayList<>(DEAD_CORAL_FAN_TYPES);
    }

    /**
     * Get all material types related to dead coral wall fan
     * @return list of material types
     */
    public static List<Material> getDeadCoralWallFanTypes(){
        return new ArrayList<>(DEAD_CORAL_WALL_FAN_TYPES);
    }

    /**
     * Get all material types related to helmet
     * @return list of material types
     */
    public static List<Material> getHelmetTypes(){
        return new ArrayList<>(HELMET_TYPES);
    }

    /**
     * Get all material types related to chestplate
     * @return list of material types
     */
    public static List<Material> getChestplateTypes(){
        return new ArrayList<>(CHESTPLATE_TYPES);
    }

    /**
     * Get all material types related to leggings
     * @return list of material types
     */
    public static List<Material> getLeggingsTypes(){
        return new ArrayList<>(LEGGINGS_TYPES);
    }

    /**
     * Get all material types related to boots
     * @return list of material types
     */
    public static List<Material> getBootsTypes(){
        return new ArrayList<>(BOOTS_TYPES);
    }

    /**
     * Get all material types related to armor
     * @return list of material types
     */
    public static List<Material> getArmorTypes(){
        return new ArrayList<>(ARMOR_TYPES);
    }

    /**
     * Get all material types related to sword
     * @return list of material types
     */
    public static List<Material> getSwordTypes(){
        return new ArrayList<>(SWORD_TYPES);
    }

    /**
     * Get all material types related to axe
     * @return list of material types
     */
    public static List<Material> getAxeTypes(){
        return new ArrayList<>(AXE_TYPES);
    }

    /**
     * Get all material types related to pickaxe
     * @return list of material types
     */
    public static List<Material> getPickaxeTypes(){
        return new ArrayList<>(PICKAXE_TYPES);
    }

    /**
     * Get all material types related to shovel
     * @return list of material types
     */
    public static List<Material> getShovelTypes(){
        return new ArrayList<>(SHOVEL_TYPES);
    }

    /**
     * Get all material types related to hoe
     * @return list of material types
     */
    public static List<Material> getHoeTypes(){
        return new ArrayList<>(HOE_TYPES);
    }
}