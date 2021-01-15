package com.example.demo.repository;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Map;

public interface IPersonRepository {
    List<Person> getAll(); //Liệt kê danh sách tất cả

    List<Person> sortPeopleByFullNameReversed(); //Liệt kê danh sách sắp xếp theo tên full name từ Z-A

    List<String> getSortedJobs(); //Lấy danh sách tất cả nghề nghiệp đã được sắp xếp từ A-Z

    List<String> getSortedCities(); //Lấy danh sách tất cả thành phố đã được sắp xếp từ A-Z

    Map<String, List<Person>> groupPeopleByCity(); //Gom tất cả những người trong cùng một thành phố lại

    /* - Hanoi
          - Nguyen Văn X  |
          - Nguyên Văn Y  | -> List<Person>
          - Bui Thi Z     |
        - New York
          - John Lenon
          - Iron Man
          - John Biden
        - Tokyo
          - Ajino Moto
          - Murakami
          - Kawazaki
    */
    Map<String, Long> groupJobByCount();  //Nhóm các nghề nghiệp và đếm số người làm mỗi nghề

    /*
    Pharmacist  - 2
    Data Coordiator - 3
    Sales Representative - 5
    */
    Map<String, Long> findTop5Jobs(); //Tìm 5 nghề có số lượng người làm nhiều nhất sắp xếp từ cao xuống thấp

    Map<String, Long> findTop5Citis(); //Tìm 5 thành phố có số người thuộc danh sách sinh sống đông nhất từ vị trí thứ 5 đến vị trí thứ 1

    Map<String, String> findTopJobInCity(); //Ở mỗi thành phố, tìm nghề nào có nhiều người làm nhất

    Map<String, Integer> averageJobSalary(); //Ứng với mỗi nghề nghiệp (job - String), tính mức lương trung bình (float)

    Map<String, Long> top5HighestSalaryCities(); //Tìm 5 thành phố có mức lương trung bình cao nhất, sắp xếp từ cao xuống thấp

    Map<String, Integer> averageJobAge(); //Ứng với mỗi loại job hãy tính độ tuổi trung bình

    Map<String, Integer> averageCityAge(); //Ứng với mỗi thành phố hãy tính độ tuổi trung bình

    List<String> find5CitiesHaveMostSpecificJob(String job); //Với một nghề cụ thể, hãy tìm ra 5 thành phố có nhiều làm nghề đó nhất

}
