#include <iostream>

using namespace std;

#define NUM 8

int a[NUM+1]={0};
int flag[NUM+1]={false};
int sum=0;

void print(){
    sum++;
    cout<<"No."<<sum<<" :"<<endl;
    for (int i=1;i<=NUM;i++){
        cout<<"   ";
        for(int j=1;j<a[i];j++) cout<<"×";
        cout<<"●";
        for(int k=a[i]+1;k<=NUM;k++) cout<<"×";
        cout<<endl;
    }
    cout<<endl;
}


bool isPlace(int t,int i){      //只需判断斜线 t为行 i为列
    for (int j=1;j<t;j++){
        if((j-a[j])==(t-i) || (j+a[j])==(t+i))
            return false;
    }
    return true;
}

void Queens(int t){
    for(int i=1;i<=NUM;i++){
        if (flag[i]==false && isPlace(t,i)){
            a[t]=i;
            flag[i]=true;
            if(t==NUM){
                print();
            }
            else Queens(t+1);
            flag[i]=false;
        }
    }
}

int main()
{
    Queens(1);
    cout<<endl<<"sum : "<<sum<<endl;
    return 0;
}
