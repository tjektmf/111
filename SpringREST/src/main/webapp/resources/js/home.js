const out = document.getElementById('out');
const btn1 = document.getElementById('btn1');
const btn2 = document.getElementById('btn2'); // JSON
const btn3 = document.getElementById('btn3'); // XML
const emps = document.getElementById('employees');
const emps2 = document.getElementById('employees2');

btn1.addEventListener('click', (e) => {
    // 1. 0Ajax 요청 객체 생성
    const xhttp = new XMLHttpRequest();

    // 2. readystatechange 이벤트 리스너 설정 
    //  - xhttp 객체의 상태가 변화할 때마다 발생하는 이벤트에 대한 설정을 해둠
    xhttp.addEventListener('readystatechange', (e) => {
        // readystate 1 : open()이 성공(send() 하기 전)
        // readystate 2 : 요청에 대한 응답이 도착했을 때
        // readystate 3 : 응답에 대한 처리를 시작했을 때
        // readystate 4 : 응답에 대한 처리가 모두 끝났을 때 (사용 준비 끝)
        // console.dir(xhttp.readyState);

        if (xhttp.readyState === 4) {
            // @RestController로 부터 응답받은 데이터는 ResponseText에 들어있다
            console.log(xhttp.responseText);

            // @RestController에서 받아온 데이터를 화면에 반영할 수 있다
            out.innerHTML += '<div>' + xhttp.responseText + '</div>';

        }

    });

    // 3. open(method, uri) : 요청을 어떤 방식으로 어디에 보낼지 설정
    xhttp.open('GET', './rest/v1');

    // 4. 요청을 보낸다 (location.href와 다르게 다음 페이지로 넘어가지 않는다)
    xhttp.send();

})

btn2.addEventListener('click', (e) => {

    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) => {
        // status : 200 은 정상일 때 나옴
        if (xhttp.readyState === 4 && xhttp.status == 200) {
            const cargo = xhttp.responseText;

            // JSON은 Javascript Object 형식의 문자열이기 때문에
            // 오브젝트로의 변환이 필요함
            console.log(cargo)
            console.dir(typeof (cargo));

            // Java의 데이터를 JS 오브젝트로 변환하여 활용
            const obj = JSON.parse(cargo);
            console.log(obj);
            console.log('employee_id : ', obj.employee_id);
            console.log('first_name : ', obj.first_name);
            console.log('last_name : ', obj.last_name);

            const newEmpId = document.createElement('div');
            const newFname = document.createElement('div');
            const newLname = document.createElement('div');

            newEmpId.classList.add('emp-id');
            newFname.classList.add('emp-fname');
            newLname.classList.add('emp-lname');

            newEmpId.innerText = obj.employee_id;
            newFname.innerText = obj.first_name;
            newLname.innerText = obj.last_name;

            emps.appendChild(newEmpId);
            emps.appendChild(newFname);
            emps.appendChild(newLname);

        }
    });
    xhttp.open('get', './rest/v4');
    xhttp.send();

})

btn3.addEventListener('click', (e) => {
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) => {
        if (xhttp.status == 200 && xhttp.readyState == 4) {

            // responseXML로 전달받은 XML데이터를 document처럼 사용할 수 있다
            console.dir(xhttp.responseXML);

            const xmlDoc = xhttp.responseXML;
            const emps = xmlDoc.getElementsByTagName('item');
            console.log(emps);

            for (let i = 0; i < emps.length; i++) {
                console.log(`### emp${i} ###`);

                const fields = emps[i].children;

                for (let j = 0; j < fields.length; j++) {
                    console.log(fields[j].tagName, ':', fields[j].innerHTML);
                }
            }
        }
    })
    xhttp.open('get', './rest/v6');
    xhttp.send();
})

const json1 = document.getElementById('json1');

json1.addEventListener('click', (e) => {

    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) => {
        if (xhttp.status == 200 && xhttp.readyState == 4) {
            // Java에서 리턴받은 값이 들어있음 JS에서 수많은 값들 중 
            // value만 사용하듯이 responseText 값만 사용함
            const cargo = xhttp.responseText;

            // 기본적으로 String 타입이라 썩 별로임
            console.log(cargo);

            // JSON.parse() 를 통해 변환
            const obj = JSON.parse(cargo);

            // JS 오브젝트로 이제 봐줄만함
            console.log(obj);

            // EmployeeDTO에서 가지고 있는 필드명으로 값을 불러올 수 있음
            for (let i = 0; i < obj.length; i++) {
                console.log('1 : ', obj[i].employee_id);
                console.log('2 : ', obj[i].first_name);
                console.log('3 : ', obj[i].last_name);
            }
            // 랜덤으로 뽑은 10명의 정보가 누적이 되지 않게함
            emps2.innerText = '';

            for (let i = 0; i < obj.length; i++) {
                const makeDiv1 = document.createElement('div');
                const makeDiv2 = document.createElement('div');
                const makeDiv3 = document.createElement('div');
                console.log(2);
                makeDiv1.innerText += obj[i].employee_id;
                makeDiv2.innerText += obj[i].first_name;
                makeDiv3.innerText += obj[i].last_name;
                emps2.appendChild(makeDiv1);
                emps2.appendChild(makeDiv2);
                emps2.appendChild(makeDiv3);
            }
        }
    })
    xhttp.open('get', './rest/v7');
    xhttp.send();
})

const xml1 = document.getElementById('xml1');

xml1.addEventListener('click', (e) => {
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) => {
        // readyState == 4 status == 200 은 그냥 사용할 준비가 됐을때 상태임
        if (xhttp.readyState == 4 && xhttp.status == 200) {

            const cargo = xhttp.responseXML;
            console.log(cargo)
            // TagName을 하는 이유는 item 태그에 값들이 저장되기 때문
            const cargo2 = cargo.getElementsByTagName('item');

            // 아이템은 가져왔는데 그 안에 여러 값들 중 children에 값이 저장되어 있음
            console.log(cargo2);
            // children 에 들어있는 값 3가지를 for문을 통해 전부 가져오고
            // item 자체도 3개있으니 for문을 통해 불러와야함


            for (let i = 0; i < cargo2.length; i++) {

                for (let j = 0; j < 3; j++) {
                    console.log(cargo2[i].children[j]);

                    const makeDiv1 = document.createElement('div');
                    const makeDiv2 = document.createElement('div');
                    const makeDiv3 = document.createElement('div');

                    makeDiv1.innerText += cargo2[i].children[j].innerHTML;
             //       makeDiv2.innerText += 
             //       makeDiv3.innerText += obj[i].last_name;
                    emps2.appendChild(makeDiv1);
             //       emps2.appendChild(makeDiv2);
             //       emps2.appendChild(makeDiv3);
                }
            }
        }
    })
    xhttp.open('get', './rest/v8');
    xhttp.send();
})