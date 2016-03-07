class Solution {
public:
    int myAtoi(string str) {
        long ret = 0;
        bool flag = true;
        const long long INTMIN_ABS = 2147483648,INTMAX = 2147483647;
        int i = 0;
        
        while(str[i]==' ') i++; //�������ַ�
        if(str[i]=='\0') return 0;
        //�����Ŵ���
        if(str[i]=='+'){flag=true;i++;}
        else if(str[i]=='-'){flag=false;i++;}
        else if((str[i]-'0'>=0)&&(str[i]-'9'<=0)) flag=true;
        else return 0;
        
        while((str[i]-'0'>=0)&&(str[i]-'9'<=0)){
            int t = str[i]-'0';
            ret = ret*10 + t;
            if((ret>INTMAX)&&(flag==true)) return INTMAX;
            if((ret>INTMIN_ABS)&&(flag==false)) return -INTMIN_ABS;
            i++;
        }
        if(flag==false) ret = -ret;
        return (int)ret;
    }
};