package stream_api.grouping_examples

import stream_api.grouping_examples.GroupingExamplesBaeldung.BlogPost

fun main() {
    val posts = listOf<BlogPost>(
        BlogPost("Title1", "Autthor1", GroupingExamplesBaeldung.BlogPostType.NEWS, 1),
        BlogPost("Title2", "Autthor2", GroupingExamplesBaeldung.BlogPostType.REVIEW, 2),
        BlogPost("Title3", "Autthor3", GroupingExamplesBaeldung.BlogPostType.GUIDE, 3),
        BlogPost("Title4", "Autthor4", GroupingExamplesBaeldung.BlogPostType.NEWS, 4)
    )
    val groupByAuthor = groupByType(posts)
    println(groupByAuthor)
}

internal fun groupByType(posts: List<BlogPost>): Map<GroupingExamplesBaeldung.BlogPostType, List<BlogPost>> {
    val authorBlogMap: Map<GroupingExamplesBaeldung.BlogPostType, List<BlogPost>> = posts
        .groupBy { it.type }
        .toMap()
    return authorBlogMap;
}