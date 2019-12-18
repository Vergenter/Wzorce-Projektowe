import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class proxyTest {
    @Test
    void getArticlesFromCachedService(){
        ArticleService articleService= new ArticleService();
        ArticleService cachedArticleService= new CachedArticleService();

        List<Article> expected=articleService.searchArticle("");
        List<Article> actual=cachedArticleService.searchArticle("");

        for (int i=0;i<expected.size();i++){
            assertEquals(expected.get(i).id,actual.get(i).id);
        }

    }
    @Test
    void getCachedCommentsService(){
        ArticleService articleService= new ArticleService();
        ArticleService cachedArticleService= new CachedArticleService();

        List<String> expectedToBeDiffrent=articleService.getComments("1");
        List<String> actual=cachedArticleService.getComments("1");
        assertTrue(expectedToBeDiffrent!=actual);
        List<String> expectedToBeEqual=cachedArticleService.getComments("1");
        assertTrue(expectedToBeEqual==actual);

    }

}
