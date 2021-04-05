package me.ffulauh.dsaa.sort;

public class ShellSort extends BaseSort{

    public static void shellSort(int[] a){
        int j;
        for(int gap=5;gap>0;gap/=2){
            for(int i=gap;i<a.length;i++){
                int tmp=a[i];
                for(j=i;j>=gap&&tmp<a[j-gap];j-=gap){
                    a[j]=a[j-gap];
                }
                a[j]=tmp;
            }
            System.out.print(gap+"排序后: ");
            printNums(a);
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,9,2,10,3,11,4,12,5,13,6,14,7,15,8,16};
        int[] b=new int[]{81,94,11,96,12,35,17,95,28,58,41,75,15,33,44,2};
        shellSort(b);
//        for(int i=init();compareTo(i,5)<0;i=add(i,1)){
//            System.out.println(i);
//        }
        for(int i=0;i<5;i++){
            System.out.println(i);
        }
    }

    public static int init(){
        return 0;
    }

    public static int compareTo(int a,int b){
        int result=0;
        if(a>b){
            result=1;
        } else if(a==b){
        } else {
            result=-1;
        }
        return result;
    }

    public static int add(int a,int delta){
        return a+delta;
    }
}
