# Task_5


#include <iostream>
#include <string>
using namespace std;

struct Data {
    int num;
    union {
        struct {
            double width;
            double height;
            double length;
            int productСode;
            char name[32];
            char color[32];
        } refrigerator;

        struct {
            int years;
            int productСode;
            double weight;
            char name[32];
            char color[32]; 
        } car;
    } myUnion;
};

int dataSize = 0;

void addData(Data* data) {

    if (data[dataSize].num == 1) {
        cout << "\n";
        cout << "Input refrigerator width: ";
        cin >> data[dataSize].myUnion.refrigerator.width;
        cout << "Input refrigerator height: ";
        cin >> data[dataSize].myUnion.refrigerator.height;
        cout << "Input refrigerator length: ";
        cin >> data[dataSize].myUnion.refrigerator.length;
        cout << "Input refrigerator productCode: ";
        cin >> data[dataSize].myUnion.refrigerator.productСode;
        cout << "Input refrigerator name: ";
        cin >> data[dataSize].myUnion.refrigerator.name;
        cout << "Input refrigerator color: ";
        cin >> data[dataSize].myUnion.refrigerator.color;
        dataSize++;
    } 
    else if (data[dataSize].num == 2) {
        cout << "\n";
        cout << "Input car years: ";
        cin >> data[dataSize].myUnion.car.years;
        cout << "Input car product code: ";
        cin >> data[dataSize].myUnion.car.productСode;
        cout << "Input car weight: ";
        cin >> data[dataSize].myUnion.car.weight;
        cout << "Input car name: ";
        cin >> data[dataSize].myUnion.car.name;
        cout << "Input car color: ";
        cin >> data[dataSize].myUnion.car.color;
        dataSize++;
    }
}

bool struct_Is_Empry(Data* data, int n) {
    int iter = 0;
    for (int i = 0; i < dataSize; i++) {
        if (data[i].num == n) iter++;
    }
    return iter == 0;
}

void printData1(Data* data, int n) {
    int b = 1, size = 0;
    int* arr = new int[dataSize];
    for (int j = 0; j < dataSize; j++) {
        if (data[j].num == n) {
            *(arr + size) = j;
            size++;
        }
    }

    if (dataSize == 0 || size == 0) cout << "Structure is empty!" << "\n";
    else {
        for (int i = 0; i < size; i++) {
            if (n == 1) {
                cout << b << ") " << "Refrigerator's width: " << data[*(arr + i)].myUnion.refrigerator.width;
                cout << "; Refrigerator's height: " << data[*(arr + i)].myUnion.refrigerator.height;
                cout << "; Refrigerator's length: " << data[*(arr + i)].myUnion.refrigerator.length;
                cout << "; Refrigerator's product code: " << data[*(arr + i)].myUnion.refrigerator.productСode;
                cout << "; Refrigerator's name: " << data[*(arr + i)].myUnion.refrigerator.name;
                cout << "; Refrigerator's color: " << data[*(arr + i)].myUnion.refrigerator.color << ";" << "\n";
                b++;
            }
            else if (n == 2) {
                cout << b << ") " << "Car is " << data[*(arr + i)].myUnion.car.years << " years old; ";
                cout << "Car's product code: " << data[*(arr + i)].myUnion.car.productСode;
                cout << "; Car's weight: " << data[*(arr + i)].myUnion.car.weight;
                cout << "; Car's color: " << data[*(arr + i)].myUnion.car.color;
                cout << "; Car's name: " << data[*(arr + i)].myUnion.car.name << ";" << "\n";
                b++;
            }
        }
    }
}

void deleteData(Data* data, int n, int index) {
    if (struct_Is_Empry(data, n)) {
        cout << "Structure is empty!";
        return;
    }
    
    int iter = -1, v = 0;
    for (int i = 0; i < dataSize; i++) {
        if (data[i].num == n) {
            if (index - 1 == v) {
                iter = i;
            }
            v++;
        }
    }

    if (index < 1 || index - 1 > iter) {
        cout << "Here are no elements for this value!" << "\n";
        return;
    }

    while (iter < dataSize - 1) {
        *(data + iter) = *(data + iter + 1);
        iter++;
    }
    dataSize--;
    cout << "Row deleted!" << "\n";
}

void printCommands() {
    cout << "All commands:" << "\n";
    cout << "0 - end the program;" << "\n";
    cout << "1 - add new refrigerator  data;" << "\n";
    cout << "2 - add new car refrigerator data;" << "\n";
    cout << "3 - print refrigerators data;" << "\n";
    cout << "4 - print cars data;" << "\n";
    cout << "5 - delete refrigerator data" << "\n";
    cout << "6 - delete car data;" << "\n\n";
}

int main() {
    Data* data = new Data[128];
   
    int command, index;
    printCommands();
    cout << "Input comand: ";
    cin >> command;
    while (command != 0) {
        switch (command) {
        case 1:
            data[dataSize].num = command;
            addData(data);
            break;
        case 2:
            data[dataSize].num = command;
            addData(data);
            break;
        case 3: printData1(data, 1);
            break;
        case 4: printData1(data, 2);
            break;
        case 5:
             if (dataSize == 0) cout << "Structure is empty!" << "\n";
             else {
                 cout << "Enter the line number you want to delete: ";
                 cin >> index;
                 deleteData(data, 1, index);
             }
             break;
        case 6:
             if (dataSize == 0) cout << "Structure is empty!" << "\n";
             else {
                 cout << "Enter the line number you want to delete: ";
                 cin >> index;
                 deleteData(data, 2, index);
             }
             break;
        default:
            cout << "The command does not exist!" << "\n\n";
            printCommands();
        }
        cout << "\nInput comand: ";
        cin >> command;
    }
    cout << "\nFinish!";
}

Task_6


#include <iostream>
using namespace std;


struct Data {
    int num;
    union {
        struct {
            double width;
            double height;
            double length;
            int productСode;
        } refrigerator;
        struct {
            int years;
            int productСode;
            double weight;
            double max_velocity;
        } car;
    } myUnion;
};

struct dataNode {
    Data data;
    dataNode* next;

    dataNode(Data data) : data(data), next(NULL) {}
};

struct data_List {
    dataNode* head;
    dataNode* tail;
    int size = 0;

    data_List() : head(NULL), tail(NULL) {}
    
    bool isEmpty() {
        return head == NULL;
    }

    bool node_Is_Empry(int n) {
        int iter = 0;
        dataNode* cur = head;
        for (int i = 0; i < getSize(); i++) {
            if (cur->data.num == n) iter++;
            cur = cur->next;
        }
        return iter == 0;
    }

    int getSize() {
        return size;
    }

    void clean() {
        head = tail = NULL;
        size = 0;
    }

    void addData(int num) {
        Data data;
        data.num = num;

        if (data.num == 1) {
            cout << "\n";
            cout << "Input refrigerator width: ";
            cin >> data.myUnion.refrigerator.width;
            cout << "Input refrigerator height: ";
            cin >> data.myUnion.refrigerator.height;
            cout << "Input refrigerator length: ";
            cin >> data.myUnion.refrigerator.length;
            cout << "Input refrigerator productCode: ";
            cin >> data.myUnion.refrigerator.productСode;
        }
        else if (data.num == 2) {
            cout << "\n";
            cout << "Input car years: ";
            cin >> data.myUnion.car.years;
            cout << "Input car product code: ";
            cin >> data.myUnion.car.productСode;
            cout << "Input car weight: ";
            cin >> data.myUnion.car.weight;
            cout << "Input car max_velocity: ";
            cin >> data.myUnion.car.max_velocity;
        }

        dataNode* node = new dataNode(data);

        if (isEmpty()) {
            head = tail = node;
        }
        else {
            tail->next = node;
            tail = node;
        }
        size++;
    }

    void print(int num) {
        dataNode* curNode = head;
        int b = 1, n = -1;
        for (int  i = 0; i < getSize(); i++) {
            if (num == 1 && curNode->data.num == num) {
                cout << b << ") " << "Refrigerator's width: " << curNode->data.myUnion.refrigerator.width;
                cout << "; Refrigerator's height: " << curNode->data.myUnion.refrigerator.height;
                cout << "; Refrigerator's length: " << curNode->data.myUnion.refrigerator.length;
                cout << "; Refrigerator's product code: " << curNode->data.myUnion.refrigerator.productСode << ";" << "\n";
                b++; n++;
            }
            else if (num == 2 && curNode->data.num == num) {
                cout << b << ") " << "Car is " << curNode->data.myUnion.car.years << " years old; ";
                cout << "Car's product code: " << curNode->data.myUnion.car.productСode;
                cout << "; Car's weight: " << curNode->data.myUnion.car.weight;
                cout << "; Car's max_velocityt: " << curNode->data.myUnion.car.max_velocity << ";" << "\n";
                b++; n++;
            }
            curNode = curNode->next;
        }
        
        if (n == -1) {
            cout << "This struct is empty!" << "\n";
            return;
        }
    }

    dataNode* getNode(int index) {
        if (isEmpty()) return NULL;
        dataNode* value = head;
        for (int i = 0; i < index; i++) {
            value = value->next;
        }
        return value;
    }

   
    void deleteNode(int num) {
        if (node_Is_Empry(num)) {
            cout << "This struct is empty!" << "\n";
            return;
        }
        
        int index;
        cout << "Enter the node's number you want to delete: ";
        cin >> index;
        
        int b = -1, n = 0;
        dataNode* data = head;
        for (int i = 0; i < getSize(); i++) {
            if (n == index) break;
            if (data->data.num == num) {
                b = i; n++;
            }
            data = data->next;
        }

        if (index <= 0 || index > size || n != index) {
            cout << "There is no node for this value!" << "\n";
            return;
        }

        if (b == 0) {
            head = head->next;
        }
        else if (b == size) {
            tail = getNode(size - 1);
        }
        else {
            data = getNode(b - 1);
            data->next = data->next->next;
        }
        size--;
        cout << "Row deleted!" << "\n";
    }
};

void printCommands() {
    cout << "All commands:" << "\n";
    cout << "0 - end the program;" << "\n";
    cout << "1 - add new refrigerator  data;" << "\n";
    cout << "2 - add new car refrigerator data;" << "\n";
    cout << "3 - print refrigerators data;" << "\n";
    cout << "4 - print cars data;" << "\n";
    cout << "5 - delete refrigerator  data" << "\n";
    cout << "6 - delete car data;" << "\n";
    cout << "7 - get list sise;" << "\n";
    cout << "8 - clean all list" << "\n\n";
    
}

int main() { 
    data_List* list = new data_List();
    
    int command, index;
    printCommands();
    cout << "Input comand: ";
    cin >> command;
    while (command != 0) {
        switch (command) {
        case 1:
            list->addData(command);
            break;
        case 2:
            list->addData(command);
            break;
        case 3: list->print(1);
            break;
        case 4: list->print(2);
            break;
        case 5:
            if (list->getSize() == 0) cout << "List is empty!" << "\n";
            else {
                list->deleteNode(1);
            }
            break;
        case 6:
            if (list->getSize() == 0) cout << "List is empty!" << "\n";
            else {
                list->deleteNode(2);
            }
            break;
        case 7: cout << "List size = " << list->getSize() << "\n";
            break;
        case 8: 
            if (list->isEmpty()) { cout << "List is empty! " << "\n"; }
              else { list->clean(); }
            break;
        default:
            cout << "The command does not exist!" << "\n\n";
            printCommands();
        }
        cout << "\nInput comand: ";
        cin >> command;
    }
    cout << "\nFinish!";
}


