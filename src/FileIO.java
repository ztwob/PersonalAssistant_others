import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileIO {
    public void createNewPack(String address,String packName){
        File myfile = new File(address+"/"+packName);
        if(!myfile.exists()){
            myfile.mkdir();
        }
        else{
            //输出 文件夹已存在
            return;
        }
    }
    public void createNewFile(String address,String fileName) throws IOException {
        File myfile = new File(address+"/"+fileName+".txt");
        if(!myfile.exists()){
            myfile.createNewFile();
        }
    }
    public boolean rename(String add,String fileName,String reName){
        File myFile = new File(add+"/"+fileName);
        File newFile = new File(add+"/"+reName);
        return myFile.renameTo(newFile);
    }

    public void addTempTask(TempTask tpTask){};
    public void addCycleTask(CycleTask cycleTask){};
    public void addLongTermTask(LongTermTask ltTask){};

    //写入
    public void outputFile(Task task){
        if(task.getType()==1){
            addTempTask((TempTask)task);
        }
        else if(task.getType()==2){
            addCycleTask((CycleTask)task);
        }
        else if(task.getType()==3){
            addLongTermTask((LongTermTask)task);
        }
    };

    //读取
    public void inputFile(String address,String fileName,TaskList list) throws IOException {
        File myFile = new File(address+"/"+fileName+".txt");
        Reader in = new Reader(myFile) {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };
        int tempchar;
        String fileString = "";
        while((tempchar=in.read())!=-1){
            fileString = fileString + tempchar;
        }
        in.close();

        int type = fileString.charAt(0);
        switch(type){
            case 1:{
                list.addTask(inTemp(fileString));break;
            }
            case 2:{
                list.addTask(cyTemp(fileString));break;
            }
            case 3:{
                break;
            }
        }
    };

    public TempTask inTemp(String string){
        String name;
        String description;
        Date ddl = new Date();

        int startIndex = string.indexOf("*");
        int endIndex = string.indexOf("*",startIndex+1);
        name = string.substring(startIndex,endIndex);
        startIndex = endIndex;
        endIndex = string.indexOf("*",startIndex+1);
        description = string.substring(startIndex,endIndex);
        startIndex = endIndex;
        endIndex = string.indexOf("*",startIndex+1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm;ss");

        try {
            ddl = dateFormat.parse(string.substring(startIndex,endIndex));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        TempTask tpTask = new TempTask(name,description,ddl);
        return tpTask;
    }

    public CycleTask cyTemp(String string){
        String name;
        String description;
        int cycle;
        int times;
        Date ddl = new Date();

        int startIndex = string.indexOf("*");
        int endIndex = string.indexOf("*",startIndex+1);
        name = string.substring(startIndex,endIndex);
        startIndex = endIndex;
        endIndex = string.indexOf("*",startIndex+1);
        description = string.substring(startIndex,endIndex);
        startIndex = endIndex;
        endIndex = string.indexOf("*",startIndex+1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm;ss");

        try {
            ddl = dateFormat.parse(string.substring(startIndex,endIndex));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        startIndex = endIndex;
        endIndex = string.indexOf("*",startIndex+1);
        cycle = Integer.parseInt(string.substring(startIndex,endIndex));
        startIndex = endIndex;
        endIndex = string.indexOf("*",startIndex+1);
        times = Integer.parseInt(string.substring(startIndex,endIndex));

        CycleTask cycleTask = new CycleTask(name,description,ddl,cycle,times);
        return cycleTask;
    }
}
