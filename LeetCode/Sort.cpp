#include <iostream>
#include "time.h"
#include<stdlib.h>

using namespace std;

const int LEN=10;

void Print(int a[],int n){
    for(int i=0;i<n;i++){
        cout<<a[i]<<" ";
    }
    cout<<endl;
}

void Swap(int &a,int &b){
    int c=a;
    a=b;
    b=c;
}

void InsertSort(int a[],int n){      //直接插入排序
    int i,j,temp;
    for(i=1;i<n;i++){
        temp=a[i];
        j=i-1;
        while(j>=0 && temp<a[j]){
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=temp;
    }
    cout<<"InsertSort: ";
    Print(a,n);
}

void ShellSort(int a[],int n){      //希尔排序（分组插入）
    int i,j,d,temp;
    d=n/2;
    while(d>0){
        for(i=d;i<n;i++){
            temp=a[i];
            j=i-d;
            while(j>=0 && temp<a[j]){
                a[j+d]=a[j];
                j-=d;
            }
            a[j+d]=temp;
        }
        d/=2;
    }
    cout<<"ShellSort: ";
    Print(a,n);
}

void BubbleSort(int a[],int n){         //冒泡排序
    for(int i=1;i<n;i++){
        for(int j=0;j<n-i;j++){
            if(a[j]>a[j+1]){
                Swap(a[j],a[j+1]);
            }
        }
    }
    cout<<"BubbleSort: ";
    Print(a,n);
}

void QuickSort(int a[],int s,int t){    //对a[s]到a[t]之间元素进行快速排序
    int i=s,j=t;
    int temp;
    if(s<t){
        temp=a[s];
        while(i!=j){
            while(j>i && a[j]>temp) j--;
            if(i<j){
                a[i]=a[j];
                i++;
            }
            while(i<j && a[i]<temp) i++;
            if(i<j){
                a[j]=a[i];
                j--;
            }
        }
        a[i]=temp;
        QuickSort(a,s,i-1);
        QuickSort(a,i+1,t);
    }
}


void SelectSort(int a[],int n){         //选择排序
    int min;
    for(int i=0;i<n;i++){
        min=i;
        for(int j=i+1;j<n;j++){
            if(a[min]>a[j]) min=j;
        }
        if(min!=i) Swap(a[min],a[i]);
    }
    cout<<"SelectSort: ";
    Print(a,n);
}

void HeapAdjust(int a[],int s,int length){      //调整堆
    int child=2*s+1;            //左节点  +1为右节点
    while(child<length){
        if(child+1<length && a[child]<a[child+1])
            child++;
        if(a[s]<a[child]){
            Swap(a[s],a[child]);
            s=child;
            child=2*s+1;
        }
        else{
            break;
        }
    }
}

void HeapSort(int a[],int length){          //堆排序
    for(int i=(length-1)/2;i>=0;--i){
        HeapAdjust(a,i,length);
    }
    for(int j=length-1;j>0;--j){
        Swap(a[j],a[0]);
        HeapAdjust(a,0,j);
    }
}

void Merge(int a[],int b[],int i,int m,int n){  //a[i..m]和a[m+1..n]合并为b[i,n]
    int j,k;
    for(j=m+1,k=i;i<=m && j<=n;k++){
        if(a[j]<a[i]) b[k]=a[j++];
        else b[k]=a[i++];
    }
    while (i<=m) b[k++]=a[i++];
    while (j<=n) b[k++]=a[j++];
}

void MSort(int a[],int b[],int s,int t){
    int p[LEN];
    if (s==t) b[s]=a[s];
    else{
        int m=(s+t)/2;
        MSort(a,p,s,m);
        MSort(a,p,m+1,t);
        Merge(p,b,s,m,t);
    }
}

void MergeSort(int a[],int b[],int n){      //归并排序
    MSort(a,b,0,n-1);
}

void NewArray(int a[],int n){       //随机数组
    srand(unsigned(time(0)));
    for(int i=0;i<n;i++){
        a[i]=rand()%100;
    }
}



int main(){
    int a[LEN];
    int b=0;


    cout<<"1:Insert Sort "<<endl;
    cout<<"2:Bubble Sort "<<endl;
    cout<<"3:Select Sort "<<endl;
    cout<<"4:Shell Sort "<<endl;
    cout<<"5:Quick Sort "<<endl;
    cout<<"6:Heap Sort "<<endl;
    cout<<"7:Merge Sort "<<endl;
    cout<<"0:Exit!"<<endl;
    do{
        cout<<endl<<"Chose Function: "<<endl;
        cin>>b;
        switch(b){
            case 1:
                cout<<"UnsortArray: ";
                NewArray(a,LEN);
                Print(a,LEN);
                InsertSort(a,LEN);
                break;
            case 2:
                cout<<"UnsortArray: ";
                NewArray(a,LEN);
                Print(a,LEN);
                BubbleSort(a,LEN);
                break;
            case 3:
                cout<<"UnsortArray: ";
                NewArray(a,LEN);
                Print(a,LEN);
                SelectSort(a,LEN);
                break;
            case 4:
                cout<<"UnsortArray: ";
                NewArray(a,LEN);
                Print(a,LEN);
                ShellSort(a,LEN);
                break;
            case 5:
                cout<<"UnsortArray: ";
                NewArray(a,LEN);
                Print(a,LEN);
                QuickSort(a,0,LEN-1);
                cout<<"QuickSort: ";
                Print(a,LEN);
                break;
            case 6:
                cout<<"UnsortArray: ";
                NewArray(a,LEN);
                Print(a,LEN);
                HeapSort(a,LEN);
                cout<<"HeapSort: ";
                Print(a,LEN);
                break;
            case 7:
                cout<<"UnsortArray: ";
                NewArray(a,LEN);
                Print(a,LEN);
                int d[LEN];
                MergeSort(a,d,LEN);
                cout<<"MergeSort: ";
                Print(d,LEN);
                break;
            case 0:
                cout<<"Exit(0)!";
                break;
            default:
                cout<<"Wrong Input!"<<endl;
        }
    }while(b!=0);
    return 0;
}
