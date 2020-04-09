import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {

        Sprint sprint1 = new Sprint("Sprint-1");

        Feature feature1 = TaskFactory
                .createFeature("Create Dashboard",
                        "Brad",
                        "Peter",
                        LocalDate.of(2020, 4, 12),
                        "Create console for debugging", FeatureImpact.LOW);

        Bug bug1 = TaskFactory
                .createBug("Fix MySQL Issue",
                        "Ryan",
                        "Ryan",
                        LocalDate.of(2020, 4, 15),
                        BugSeverity.P0);

        Story story1 = TaskFactory
                .createStory("Create a microservice",
                        "Amy",
                        "Ryan",
                        LocalDate.of(2020, 4, 20),
                        "Add logging to this feature");

        Feature feature2 = TaskFactory
                .createFeature("Setup console",
                        "Ryan",
                        "Ryan",
                        LocalDate.of(2020, 4, 1),
                        "Create console for debugging", FeatureImpact.HIGH);

        Feature feature3 = TaskFactory
                .createFeature("Console api",
                        "Ryan",
                        "Ryan",
                        LocalDate.of(2020, 4, 5),
                        "Create api for console", FeatureImpact.HIGH);
        //feature3.setStatus(FeatureStatus.DEPLOYED);

        TaskFactory.createSubTrack("Development", story1);
        TaskFactory.createSubTrack("Unit Test", story1);
        TaskFactory.createSubTrack("Integration Test", story1);


        Story story2 = TaskFactory
                .createStory("Create a microservice 2",
                        "Amy",
                        "Ryan",
                        LocalDate.of(2020, 4, 20),
                        "Add cache to this feature");

        TaskFactory.createSubTrack("Development", story2);
        TaskFactory.createSubTrack("Unit Test", story2);

        story2.setStatus(StoryStatus.COMPLETED);
        TaskFactory.createSubTrack("Deploy", story2);

        sprint1.addTask(feature1);
        sprint1.addTask(bug1);
        sprint1.addTask(story1);
        sprint1.addTask(feature2);
        sprint1.addTask(feature3);

        Sprint sprint2 = new Sprint("Sprint-2");


        TaskPlanner planner = new TaskPlanner();
        planner.addSprint(sprint1);

        sprint1.displaySprintStatus();

        planner.displayUserStatus("Peter");




    }
}
