import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextBox {
    List<String> text;
    TextBox(String... args){
        text = Arrays.asList(args);
    }
    static <T> List<T> swap(List<T> list){
        List<T> cpy=list.stream().collect(Collectors.toList());
        T tmp;
        for(int i=0;i+1<cpy.size();i+=2){
            tmp=cpy.get(i);
            cpy.set(i,cpy.get(i+1));
            cpy.set(i+1,tmp);
        }
        return cpy;
    }
    static List<String> swapLines(List<String> text){
        return swap(text);
    }
    static List<String> swapWords(List<String> text){
        return text.stream().map(
                line ->  String.join(
                        " ",
                        swap(Arrays.asList(line.split(" ")))
                )
        ).collect(Collectors.toList());
    }
    static List<String> swapLetters(List<String> text){
        return text.stream().map(
                line-> (swap(line.chars()
                        .mapToObj(e->(char)e).collect(Collectors.toList()))).stream().map(String::valueOf).collect(Collectors.joining())
        ).collect(Collectors.toList());
    }
}
