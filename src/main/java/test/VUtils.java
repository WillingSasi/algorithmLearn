package test;

public class VUtils {

    public static void main(String[] args) {
//        isTrue(true).throwMessage("我要抛出异常");
//        isTrueOrFalse(false).trueOrFalseHandle(() -> {
//            System.out.println("True PPP");
//        }, () -> {
//            System.out.println("False PPP");
//        });

        ispresentOrElseHandler("aaa").presentOrElseHandle(System.out::println, () -> {
            System.out.println("字符串为空");
        });
    }

    public static ThrowExceptionFunction isTrue(boolean b) {
        return message -> {
            if (b) {
                throw new RuntimeException(message);
            }
        };
    }

    public static BranchHandle isTrueOrFalse(boolean b) {
        return ((trueHandle, falseHandle) -> {
            if (b) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        });
    }

    public static PresentOrElseHandler<?> ispresentOrElseHandler(String str){
        return (consumer, runnable) -> {
            if (str == null || str.length() == 0) {
                runnable.run();
            }else {
                consumer.accept(str);
            }
        };
    }
}
