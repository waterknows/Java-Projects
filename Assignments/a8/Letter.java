package a8;
public class Letter{
    private String from;
    private String to;
    private String contents;
    public Letter(){
        from = "";
        to = "";
        contents = "";
    }
    public Letter(String from, String to){
        this.from = from;
        this.to = to;
        contents = "";
    }
    public void addLine(String line){
        contents += line + "\n";
    }
    public String getText(){
        String letter = "Dear " + to + ":\n\n";
        letter += contents + "\n";
        letter += "Sincerely, \n\n" + from;
        return letter;
    }
    
}