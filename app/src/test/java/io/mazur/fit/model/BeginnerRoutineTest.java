package io.mazur.fit.model;

import com.google.gson.Gson;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BeginnerRoutineTest {
    private Routine mJSONRoutine;
    private BeginnerRoutine mBeginnerRoutine;

    @Before
    public void before() throws Exception {
        /**
         * TODO: Load from file.
         */
        mJSONRoutine = new Gson().fromJson("{\n" +
                "  \"routine\" : [\n" +
                "    {\n" +
                "      \"title\": \"Warmup\",\n" +
                "      \"type\": \"category\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Dynamic Stretches (Do all, 5-10 reps each)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"all\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"wall_extensions\",\n" +
                "      \"title\": \"Wall Extensions\",\n" +
                "      \"description\": \"5-10 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"band_dislocates\",\n" +
                "      \"title\": \"Band Dislocates\",\n" +
                "      \"description\": \"5-10 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"cat_camel\",\n" +
                "      \"title\": \"Cat/Camel Bends\",\n" +
                "      \"description\": \"5-10 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"scapular_shrugs\",\n" +
                "      \"title\": \"Scapular Shrugs\",\n" +
                "      \"description\": \"5-10 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"full_body_circles\",\n" +
                "      \"title\": \"Full Body Circles\",\n" +
                "      \"description\": \"5-10 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"leg_swings\",\n" +
                "      \"title\": \"Front and Side Leg Swings\",\n" +
                "      \"description\": \"5-10 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"wrist_progression\",\n" +
                "      \"title\": \"Wrist Mobility Exercises\",\n" +
                "      \"description\": \"5-10 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Bodyline Drills (Do all, 10-60s hold each)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"all\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"plank\",\n" +
                "      \"title\": \"Plank\",\n" +
                "      \"description\": \"10-60s hold\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"side_plank\",\n" +
                "      \"title\": \"Side Plank (Both sides)\",\n" +
                "      \"description\": \"10-60s hold\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"reverse_plank\",\n" +
                "      \"title\": \"Reverse Plank\",\n" +
                "      \"description\": \"10-60s hold\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"hollow_hold\",\n" +
                "      \"title\": \"Hollow Hold\",\n" +
                "      \"description\": \"10-60s hold\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"arch\",\n" +
                "      \"title\": \"Arch\",\n" +
                "      \"description\": \"10-60s hold\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Activity (Pick one, 10-20 reps)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"pick\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"squat_jumps\",\n" +
                "      \"title\": \"Squat Jumps\",\n" +
                "      \"description\": \"10-20 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"burpee\",\n" +
                "      \"title\": \"Burpees\",\n" +
                "      \"description\": \"10-20 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Skill Work\",\n" +
                "      \"type\": \"category\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Handstand (5 min)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"wall_plank\",\n" +
                "      \"title\": \"Level 1: Wall Plank\",\n" +
                "      \"description\": \"5 minutes\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"wall_handstand\",\n" +
                "      \"title\": \"Level 2: Stomach-to-Wall Handstand\",\n" +
                "      \"description\": \"5 minutes\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"freestanding_handstand\",\n" +
                "      \"title\": \"Level 3: Freestanding Handstand\",\n" +
                "      \"description\": \"5 minutes\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Support Practice (2-3 min)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"parallel_bar_hold\",\n" +
                "      \"title\": \"Level 1: Parallel Bar support\",\n" +
                "      \"description\": \"2-3 minutes\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"ring_support\",\n" +
                "      \"title\": \"Level 2: Ring Support\",\n" +
                "      \"description\": \"2-3 minutes\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"rings_turned_out_support\",\n" +
                "      \"title\": \"Level 3: Rings Turned Out Support Hold\",\n" +
                "      \"description\": \"2-3 minutes\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Strength Work\",\n" +
                "      \"type\": \"category\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Pullup Progression 3x(5-8)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"negative_pullup\",\n" +
                "      \"title\": \"Level 1: Negative Pullups\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"pullup\",\n" +
                "      \"title\": \"Level 2: Pull Up\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"lsit_pullup\",\n" +
                "      \"title\": \"Level 3: L-sit Pull Up\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"pullover\",\n" +
                "      \"title\": \"Level 4: Pull Over\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Dipping Progression 3x(5-8)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"parallel_bar_dips\",\n" +
                "      \"title\": \"Level 1: Parallel Bar Dips\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"ring_dips\",\n" +
                "      \"title\": \"Level 2: Ring Dips\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"l_ring_dips\",\n" +
                "      \"title\": \"Level 3: Ring Dips in L-sit\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Squat Progression 3x(5-8)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"assisted_squat\",\n" +
                "      \"title\": \"Level 1: Assisted Bodyweight Squat\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"bodyweight_squat\",\n" +
                "      \"title\": \"Level 2: Bodyweight Squat\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"deep_stepup\",\n" +
                "      \"title\": \"Level 3: Deep Step-up\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"L-sit Progression 3x(10-30s)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"floor_l_sit\",\n" +
                "      \"title\": \"Level 1: Foot-supported L-sit\",\n" +
                "      \"description\": \"3x(10-30s)\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"one_foot_l_sit\",\n" +
                "      \"title\": \"Level 2: One-Leg Foot Supported L-sit\",\n" +
                "      \"description\": \"3x(10-30s)\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"tuck_l_sit\",\n" +
                "      \"title\": \"Level 3: Tuck L-sit\",\n" +
                "      \"description\": \"3x(10-30s)\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"l_sit\",\n" +
                "      \"title\": \"Level 4: L-sit\",\n" +
                "      \"description\": \"3x(10-30s)\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Pushing 3x(5-8)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"wall_pushup\",\n" +
                "      \"title\": \"Level 1: Wall Pushup\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"incline_pushup\",\n" +
                "      \"title\": \"Level 2: Incline Pushup\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"pushup\",\n" +
                "      \"title\": \"Level 3: Pushup\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"diamond_pushup\",\n" +
                "      \"title\": \"Level 4: Diamond Pushup\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"ring_pushup\",\n" +
                "      \"title\": \"Level 5: Rings Push Ups\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"rings_turned_out_pushup\",\n" +
                "      \"title\": \"Level 5: Rings Turned Out Push Up\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"pseudo_planche_pushup\",\n" +
                "      \"title\": \"Level 7: Rings Turned Out PPPU\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"pseudo_planche\",\n" +
                "      \"title\": \"Level 5-7 (No Rings): Pseudo Planche Push Ups\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Row Progression 3x(5-8)\",\n" +
                "      \"type\": \"section\",\n" +
                "      \"mode\": \"levels\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"vertical_row\",\n" +
                "      \"title\": \"Level 1: Vertical Row\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"incline_row\",\n" +
                "      \"title\": \"Level 2: Incline Row\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"horizontal_row\",\n" +
                "      \"title\": \"Level 3: Horizontal Row\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"wide_row\",\n" +
                "      \"title\": \"Level 4: Wide Row\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"tuck_front_lever\",\n" +
                "      \"title\": \"Level 5: Tuck Front Lever\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"tuck_ice_cream_maker\",\n" +
                "      \"title\": \"Level 6: Tuck Ice Cream Maker\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"tuck_front_lever_row\",\n" +
                "      \"title\": \"Level 7: Tuck Front Lever Row\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"advanced_tuck_front_lever_row\",\n" +
                "      \"title\": \"Level 8: Advanced Tuck Front Lever Row\",\n" +
                "      \"description\": \"3 sets of 5-8 reps\",\n" +
                "      \"type\": \"exercise\"\n" +
                "    }\n" +
                "  ]\n" +
                "}", Routine.class);

        mBeginnerRoutine = new BeginnerRoutine(mJSONRoutine);
    }

    @Test
    public void jsonRoutineIsSetTest() {
        assertNotNull(mJSONRoutine);
        assertEquals(mJSONRoutine.getSize(), 64);
    }

    @Test
    public void routineIsCreatedTest() {
        assertNotNull(mBeginnerRoutine);
    }

    @Test
    public void categoriesAreInsertedTest() {
        assertEquals(mBeginnerRoutine.getCategories().size(), 3);
    }

    @Test
    public void sectionsAreInsertedTest() {
        Category category0 = mBeginnerRoutine.getCategories().get(0);
        Category category1 = mBeginnerRoutine.getCategories().get(1);
        Category category2 = mBeginnerRoutine.getCategories().get(2);

        assertEquals(category0.getSections().size(), 3);
        assertEquals(category1.getSections().size(), 2);
        assertEquals(category2.getSections().size(), 6);

        assertEquals(mBeginnerRoutine.getSections().size(), 11);
    }

    @Test
    public void exercisesAreInsertedTest() {
        Section section0 = mBeginnerRoutine.getCategories().get(0).getSections().get(0);

        assertEquals(section0.getExercises().size(), 7);
        assertEquals(mBeginnerRoutine.getExercises().size(), 50);
    }

    @Test
    public void linkedExercisesAreInsertedTest() {
        ArrayList<Exercise> linkedExercises = mBeginnerRoutine.getLinkedExercises();

        assertEquals(linkedExercises.size(), 22);

        Exercise exercise0 = linkedExercises.get(0);
        Exercise exercise1 = linkedExercises.get(1);
        Exercise exercise2 = linkedExercises.get(2);

        assertEquals(exercise0.getTitle(), "Wall Extensions");
        assertEquals(exercise1.getTitle(), "Band Dislocates");
        assertEquals(exercise2.getTitle(), "Cat/Camel Bends");

        assertNull(exercise0.getPrevious());
        assertEquals(exercise0.getNext(), exercise1);

        assertEquals(exercise1.getPrevious(), exercise0);
        assertEquals(exercise1.getNext(), exercise2);

        assertEquals(exercise2.getPrevious(), exercise1);
        assertNotNull(exercise2.getNext());
    }

    @Test
    public void linkedRoutineIsInsertedTest() {
        assertEquals(mBeginnerRoutine.getLinkedRoutine().size(), 64);
    }

    @Test
    public void sectionsAreUpdatedWhenChangingLevelsTest() {
        Section levelsSection = mBeginnerRoutine.getCategories().get(2).getSections().get(0);

        assertEquals(levelsSection.getSectionMode(), SectionMode.LEVELS);
        assertEquals(levelsSection.getCurrentLevel(), 0);
    }

    @Test
    public void setSectionLevelTest() {
        Exercise levelExercise = mBeginnerRoutine.getLinkedExercises().get(21);
        Section levelSection = levelExercise.getSection();

        assertEquals(levelSection.getSectionMode(), SectionMode.LEVELS);
        assertEquals(levelSection.getCurrentLevel(), 0);
        assertEquals(levelSection.getAvailableLevels(), 8);

        mBeginnerRoutine.setLevel(levelExercise, 1);

        assertEquals(levelSection.getCurrentLevel(), 1);
        assertEquals(levelExercise.getSection().getCurrentLevel(), 1);

        mBeginnerRoutine.setLevel(levelExercise, 2);

        assertEquals(levelSection.getCurrentLevel(), 2);
        assertEquals(levelExercise.getSection().getCurrentLevel(), 2);
    }

    @Test
    public void linkedExercisesTest() {
        ArrayList<Exercise> linkedExercises = mBeginnerRoutine.getLinkedExercises();

        Exercise levelUpExercise = linkedExercises.get(14);

        assertEquals(linkedExercises.get(0).getTitle(), "Wall Extensions");
        assertEquals(linkedExercises.get(4).getTitle(), "Full Body Circles");
        assertEquals(linkedExercises.get(10).getTitle(), "Hollow Hold");
        assertEquals(linkedExercises.get(14).getTitle(), "Level 1: Wall Plank");
        assertEquals(linkedExercises.get(15).getTitle(), "Level 1: Parallel Bar support");

        mBeginnerRoutine.setLevel(levelUpExercise, 1);

        linkedExercises = mBeginnerRoutine.getLinkedExercises();

        assertEquals(linkedExercises.get(0).getTitle(), "Wall Extensions");
        assertEquals(linkedExercises.get(4).getTitle(), "Full Body Circles");
        assertEquals(linkedExercises.get(10).getTitle(), "Hollow Hold");
        assertEquals(linkedExercises.get(14).getTitle(), "Level 2: Stomach-to-Wall Handstand");
        assertEquals(linkedExercises.get(15).getTitle(), "Level 1: Parallel Bar support");
    }
}
