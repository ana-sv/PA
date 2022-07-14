package EXAMES.Exame2022.perg1_4;


import java.io.InvalidObjectException;

class MyException extends InvalidObjectException{
    public MyException(String reason){
        super(reason);
    }

    @Override
    public String toString(){
        return "Error: "+super.toString();
    }
}

class Project{
    String name;
    String teacher; 
    String student; 

    public Project(String name, String teacher, String student) throws Exception{
        this.name = name; 
        this.teacher = teacher;
        this.student = student; 
        if( teacher.equals(student))
            throw new MyException( "Teacher and Student have the same name");
    }

    @Override
    public String toString(){
        return String.format("%s / %s / %s ", name, teacher,student);
    }
}

public class Main4 {

    public static Project createProject(String name, String teacher, String student){
        try{
            return new Project(name, teacher, student);
        } catch(MyException e){
            System.out.println("Msg A");
        }catch(Exception e){
            System.out.println("Msg B");
        } finally{
            System.out.println("Msg C");
        }
        System.out.println("Msg D");
        return null; 
    }

    public static void main(String[] args ){
        System.out.println("Begin");

        Project a =  createProject("A", "B", "C");
        System.out.println("-");
        Project b =  createProject("A", "B", "B");
        System.out.println("-");
        Project c =  createProject("A", null, "C");
        System.out.println(a+"\n"+b+"\n"+c);
        System.out.println("End");
    }
    
}
