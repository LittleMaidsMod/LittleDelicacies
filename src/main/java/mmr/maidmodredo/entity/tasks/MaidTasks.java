package mmr.maidmodredo.entity.tasks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import mmr.maidmodredo.entity.LittleMaidBaseEntity;
import mmr.maidmodredo.init.LittleEntitys;
import mmr.maidmodredo.init.MaidJob;
import mmr.maidmodredo.init.MaidMemoryModuleType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.*;
import net.minecraft.village.PointOfInterestType;

public class MaidTasks {
    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> core(float p_220638_1_) {
        return ImmutableList.of(Pair.of(0, new SwimTask(0.4F, 0.8F)), Pair.of(0, new InteractWithDoorTask()), Pair.of(0, new LookTask(45, 90)), Pair.of(0, new MaidCombatOrPanic()), Pair.of(0, new WakeUpTask()), Pair.of(1, new WalkToTargetTask(200)), Pair.of(1, new WalkToItem()), Pair.of(10, new GatherPOITask(PointOfInterestType.HOME, MemoryModuleType.HOME, false)));
    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> cutWood(float p_220636_1_) {
        return ImmutableList.of(Pair.of(0, new LumberJackTask()));
    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> rest(float p_220635_1_) {
        return ImmutableList.of(Pair.of(2, new MaidStayNearPointTask(MemoryModuleType.HOME, p_220635_1_, 1, 150, 1200)), Pair.of(3, new ExpirePOITask(PointOfInterestType.HOME, MemoryModuleType.HOME)), Pair.of(3, new SleepAtHomeTask()), Pair.of(5, new FirstShuffledTask<>(ImmutableMap.of(MemoryModuleType.HOME, MemoryModuleStatus.VALUE_ABSENT), ImmutableList.of(Pair.of(new WalkToHouseTask(p_220635_1_), 1), Pair.of(new WalkRandomlyTask(p_220635_1_), 4), Pair.of(new WalkToPOIMaidTask(p_220635_1_, 4), 2), Pair.of(new DummyTask(20, 40), 2)))), func_220646_b(), Pair.of(99, new UpdateActivityTask()));
    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> idle(float p_220641_1_) {
        return ImmutableList.of(Pair.of(2, new FirstShuffledTask<>(ImmutableList.of(Pair.of(InteractWithEntityTask.func_220445_a(LittleEntitys.LITTLEMAID, 8, MemoryModuleType.INTERACTION_TARGET, p_220641_1_, 2), 2), Pair.of(InteractWithEntityTask.func_220445_a(EntityType.VILLAGER, 8, MemoryModuleType.INTERACTION_TARGET, p_220641_1_, 2), 1), Pair.of(InteractWithEntityTask.func_220445_a(EntityType.CAT, 8, MemoryModuleType.INTERACTION_TARGET, p_220641_1_, 2), 1), Pair.of(new FindWalkTargetTask(p_220641_1_), 1), Pair.of(new WalkTowardsLookTargetTask(p_220641_1_, 2), 1), Pair.of(new JumpOnBedTask(p_220641_1_), 1), Pair.of(new DummyTask(30, 60), 1)))), Pair.of(3, new FindInteractionAndLookTargetTask(EntityType.PLAYER, 4)), func_220643_a(), Pair.of(99, new UpdateActivityTask()));
    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> follow(MaidJob p_220639_0_, float p_220641_1_) {
        if (p_220639_0_ == MaidJob.TORCHER) {
            return ImmutableList.of(Pair.of(0, new WalkToOwner(100)), Pair.of(1, new TorchPlaceTask()), Pair.of(4, new FindWalkTargetTask(p_220641_1_)), func_220646_b());
        } else {
            return ImmutableList.of(Pair.of(0, new WalkToOwner(100)), func_220646_b());
        }


    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> waiting() {
        return ImmutableList.of(func_220643_a());
    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> panic(float p_220636_1_) {
        float f = p_220636_1_ * 1.5F;
        return ImmutableList.of(Pair.of(0, new MaidClearHurtTask()), Pair.of(1, new FleeTask(MemoryModuleType.NEAREST_HOSTILE, f)), Pair.of(1, new FleeTask(MemoryModuleType.HURT_BY_ENTITY, f)), Pair.of(3, new FindWalkTargetTask(f, 2, 2)), func_220646_b());
    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> attack(float p_220636_1_) {
        float f = p_220636_1_ * 1.25F;
        return ImmutableList.of(Pair.of(0, new AttackTask(MaidMemoryModuleType.TARGET_HOSTILES, f)));
    }

    public static ImmutableList<Pair<Integer, ? extends Task<? super LittleMaidBaseEntity>>> shot(float p_220636_1_) {
        float f = p_220636_1_ * 1.2F;
        return ImmutableList.of(Pair.of(0, new BowShootTask(MaidMemoryModuleType.TARGET_HOSTILES, f)));
    }

    private static Pair<Integer, Task<LivingEntity>> func_220643_a() {
        return Pair.of(5, new FirstShuffledTask<>(ImmutableList.of(Pair.of(new LookAtEntityTask(LittleEntitys.WANDERMAID, 8.0F), 2), Pair.of(new LookAtEntityTask(LittleEntitys.LITTLEMAID, 8.0F), 2), Pair.of(new LookAtEntityTask(EntityType.CAT, 8.0F), 8), Pair.of(new LookAtEntityTask(EntityType.VILLAGER, 8.0F), 2), Pair.of(new LookAtEntityTask(EntityType.PLAYER, 8.0F), 2), Pair.of(new LookAtEntityTask(EntityClassification.CREATURE, 8.0F), 1), Pair.of(new LookAtEntityTask(EntityClassification.WATER_CREATURE, 8.0F), 1), Pair.of(new LookAtEntityTask(EntityClassification.MONSTER, 8.0F), 1), Pair.of(new DummyTask(30, 60), 2))));
    }

    private static Pair<Integer, Task<LivingEntity>> func_220646_b() {
        return Pair.of(5, new FirstShuffledTask<>(ImmutableList.of(Pair.of(new LookAtEntityTask(LittleEntitys.WANDERMAID, 8.0F), 2), Pair.of(new LookAtEntityTask(LittleEntitys.LITTLEMAID, 8.0F), 2), Pair.of(new LookAtEntityTask(EntityType.VILLAGER, 8.0F), 2), Pair.of(new LookAtEntityTask(EntityType.PLAYER, 8.0F), 2), Pair.of(new DummyTask(30, 60), 8))));
    }
}
