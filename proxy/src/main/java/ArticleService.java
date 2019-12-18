import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticleService {
    List<Article> searchArticle(String keyword){
        return Arrays.asList(
                new Article("1"),
                new Article("2"),
                new Article("3"),
                new Article("4"),
                new Article("5"),
                new Article("6")
        );
    }
    List<String> getComments(String articleId){
        return Arrays.asList(
                "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                articleId
        );
    }
}
