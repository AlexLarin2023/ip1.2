import org.testng.annotations.Test;

public class InstaProject extends BaseTest {

    @Test
    public void likePosts() {

        // Call the scrollAndLikePosts method to start scrolling and liking posts
        mainPage.scrollAndLikePosts();
    }

    @Test
    public void likeStoriesSwipe() {

        // Click the Second story on the Stories page
        mainPage.clickSecondStory();

        // Like the current story
        stories.clickLikeStoryButton();

        stories.clickRightArrow(5);
        // Like the current story
        stories.clickLikeStoryButton();

        stories.clickRightArrow(5);
        // Like the current story
        stories.clickLikeStoryButton();

        stories.clickRightArrow(5);
        // Like the current story
        stories.clickLikeStoryButton();

        stories.clickRightArrow(5);
        // Like the current story
        stories.clickLikeStoryButton();

        stories.clickRightArrow(5);
        // Like the current story
        stories.clickLikeStoryButton();

        stories.clickRightArrow(5);
        // Like the current story
        stories.clickLikeStoryButton();
    }


//        @Test
//        public void likeStories() {
//
//            // Click the Second story on the Stories page
//            mainPage.clickSecondStory() ;
//
//            // Like the current story
//            stories.clickLikeStoryButton();
//
//            // Click the "Instagram" button on the main page
//            stories.clickCloseButton();
//
//
//            // Click the third story on the Stories page
//            mainPage.clickThirdStory();
//
//            // Like the current story
//            stories.clickLikeStoryButton();
//
//            // Click the "Instagram" button on the main page
//            stories.clickCloseButton();
//
//
//            // Click the fourth story on the Stories page
//            mainPage.clickFourthStory();
//
//            // Like the current story
//            stories.clickLikeStoryButton();
//
//            // Click the "Instagram" button on the main page
//            stories.clickCloseButton();
//
//
//            // Click the fifth story on the Stories page
//            mainPage.clickFifthStory();
//
//            // Like the current story
//            stories.clickLikeStoryButton();
//
//            // Click the "Instagram" button on the main page
//            stories.clickCloseButton();
//        }


    }
