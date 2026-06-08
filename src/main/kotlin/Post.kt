data class Post (
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val comments: Comments,
    val likes: Likes
)

data class Comments (
    val count: Int = 0,
    val canPost: Boolean = true
)

data class Likes (
    val count: Int = 0,
    val canLike: Boolean = true
)

object WallService {
    private var posts = emptyArray<Post>()
    private var postId: Int = 0

    fun add(post: Post): Post {
        postId ++
        val postWithId = post.copy (id = postId)
        posts += postWithId
        return postWithId
    }

    fun update(post: Post): Boolean {
        for (index in posts.indices) {
            if (posts[index].id == post.id) {
                posts[index] = posts[index].copy(
                    fromId = post.fromId,
                    date = post.date,
                    text = post.text,
                    comments = post.comments,
                    likes = post.likes,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned
                )
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        postId = 0
    }
}