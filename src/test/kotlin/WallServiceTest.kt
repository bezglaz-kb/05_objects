import org.junit.Assert.*
import org.junit.Test
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPost() {
        val post1 = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            date = 20260608,
            text = "Today",
            comments = Comments(),
            likes = Likes()
        )

        val createdPost = WallService.add(post1)
        assertNotEquals(0, createdPost.id)
    }

    @Test
    fun updatePostTrue() {
        val originalPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            date = 20260608,
            text = "Today",
            comments = Comments(),
            likes = Likes()
        )
        val addedPost = WallService.add(originalPost)

        val updatePost = Post(
            id = 1,
            ownerId = 1,
            fromId = 1,
            date = 20260608,
            text = "Tomorrow",
            comments = Comments(),
            likes = Likes()
        )
        val result = WallService.update(updatePost)

        assertTrue(result)
    }

    @Test
    fun updatePostFalse() {
        val originalPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            date = 20260608,
            text = "Today",
            comments = Comments(),
            likes = Likes()
        )
        val addedPost = WallService.add(originalPost)

        val updatePost = Post(
            id = 999,
            ownerId = 1,
            fromId = 1,
            date = 20260608,
            text = "Tomorrow",
            comments = Comments(),
            likes = Likes()
        )
        val result = WallService.update(updatePost)

        assertFalse(result)
    }
}