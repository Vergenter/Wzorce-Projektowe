import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachedArticleService extends ArticleService {

    Map<String,List<String>> cachedComments;
    CachedArticleService(){
        cachedComments = new HashMap<String, List<String>>();
    }
    @Override
    List<Article> searchArticle(String keyword) {
        ArticleService articleService=CachedArticleService.getArticleService();
        return articleService.searchArticle(keyword);
    }
    @Override
    List<String> getComments(String articleId){
        List<String> result=cachedComments.get(articleId);
        if(result!=null){
            return result;
        }
        ArticleService articleService=CachedArticleService.getArticleService();
        cachedComments.put(articleId,articleService.getComments(articleId));
        return cachedComments.get(articleId);
    }
    private static ArticleService getArticleService(){
        return new ArticleService();
    }
}
