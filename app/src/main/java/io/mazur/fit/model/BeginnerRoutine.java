package io.mazur.fit.model;

import java.util.ArrayList;

public class BeginnerRoutine {
    /**
     * Categories are treated as top level parent for the sections and exercises.
     */
    private ArrayList<Category> mCategories = new ArrayList<>();

    /**
     * All sections put together inside a list.
     */
    private ArrayList<Section> mSections = new ArrayList<>();

    /**
     * All exercises put together inside a list, used to link exercises after changes.
     */
    private ArrayList<Exercise> mExercises = new ArrayList<>();

    /**
     * Linked exercises for switching between them. This could and should be implemented as an
     * independent screen manager later which allows linking different views together
     * (e.g. rest view or summary).
     */
    private ArrayList<Exercise> mLinkedExercises = new ArrayList<>();

    /**
     * Linked routine for displaying views in the recycler view as we can just request
     * type of the object.
     */
    private ArrayList<LinkedRoutine> mLinkedRoutine = new ArrayList<>();

    public BeginnerRoutine(Routine routine) {
        Category currentCategory = null;
        Section currentSection = null;
        Exercise currentExercise = null;

        for(Routine.PartRoutine partRoutine : routine.getPartRoutines()) {
            /**
             * Update categories in both lists.
             */
            if(partRoutine.getType() == RoutineType.CATEGORY) {
                currentCategory = new Category(partRoutine.getTitle());

                mCategories.add(currentCategory);
                mLinkedRoutine.add(currentCategory);
            }

            /**
             * Updated sections for each category and add into linked routine.
             */
            else if(partRoutine.getType() == RoutineType.SECTION) {
                currentSection = new Section(partRoutine.getTitle(), partRoutine.getMode());

                currentCategory.insertSection(currentSection);

                mSections.add(currentSection);
                mLinkedRoutine.add(currentSection);
            }

            /**
             * Update exercises for each section, link them together.
             */
            else if(partRoutine.getType() == RoutineType.EXERCISE) {
                Exercise exercise = new Exercise(partRoutine.getId(), partRoutine.getTitle(), partRoutine.getDescription());
                exercise.setPrevious(currentExercise);

                // Link exercises together
                if(currentExercise != null) {
                    currentExercise.setNext(exercise);
                }

                currentExercise = exercise;

                /**
                 * Add exercise into a section.
                 */
                currentSection.insertExercise(exercise);

                /**
                 * List contains all exercises, no matter what level.
                 */
                mExercises.add(exercise);

                /**
                 * Add only first level of exercise when linking.
                 */
                if(currentSection.getSectionMode() == SectionMode.LEVELS) {
                    if(currentSection.getExercises().size() == 1) {
                        mLinkedExercises.add(exercise);
                    }
                } else {
                    mLinkedExercises.add(exercise);
                }

                /**
                 * Linked routine contains all exercises, no matter what level.
                 */
                mLinkedRoutine.add(exercise);
            }
        }
    }

    public ArrayList<Category> getCategories() {
        return mCategories;
    }

    public ArrayList<Section> getSections() {
        return mSections;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises;
    }

    public ArrayList<Exercise> getLinkedExercises() {
        return mLinkedExercises;
    }

    /**
     * Set level of the exercise in given section.
     */
    public void setLevel(Exercise exercise, int level) {
        Section section = exercise.getSection();
        section.setCurrentLevel(level);

        /**
         * Clear current linked exercises.
         */
        mLinkedExercises.clear();

        /**
         * Loop through exercises and link them together based on level changes.
         */
        Section currentSection;
        for(Exercise currentExercise : getExercises()) {
            currentSection = currentExercise.getSection();

            switch(currentSection.getSectionMode()) {
                case ALL:
                case PICK:
                    mLinkedExercises.add(currentExercise);

                    break;
                case LEVELS:
                    /**
                     * Add only exercise for given level.
                     */
                    if(currentSection.getCurrentExercise() == currentExercise) {
                        mLinkedExercises.add(currentExercise);
                    }

                    break;
            }
        }
    }

    public ArrayList<LinkedRoutine> getLinkedRoutine() {
        return mLinkedRoutine;
    }
}
