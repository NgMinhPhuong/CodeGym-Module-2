import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadAndWriteFile {
    static void copyFile(String sourceFile, String fileTarget){

        File source = new File(sourceFile);
        File target = new File(fileTarget);
        try {
            if(source.isFile()){
                Files.copy(source.toPath(), target.toPath());
            } else{
                Files.copy(source.toPath(), target.toPath());
                File [] arrFile = source.listFiles();
                for(File x : arrFile){
                    copyFile(source.toPath() + "\\"+x.getName(),
                            target.toPath()+"\\" + x.getName());
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\practice-ReadAndWrite-file\\src\\source_need_copy");
        File target = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\practice-ReadAndWrite-file\\src\\copy_to_here\\source-COPY");
        copyFile(source.getAbsolutePath(), target.getAbsolutePath());
        // Khi chạy chương trình sẽ thực hiện nó sẽ copy cả cây thư mục source_need_copy vào trong thư mục copy_to-here
        // với tên là source-COPY
    }
}
