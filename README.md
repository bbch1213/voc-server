 * 프로젝트 구성
JAVA VERSION = 8 ( 현업에서 사용하고 있는 가장 편한 버전이라 선택했습니다. )
SPRING BOOT VERSION = 2.4.2 ( 현업에서는 더 낮은 버전을 사용하고 있지만 작업해본 경험이 있는 버전이라 선택했습니다. )
DATABASE = H2 DATABASE ( 과제 확인 시 어플리케이션 실행, 기능테스트에 유용하기 때문에 선택했습니다. )
사용한 기술 스택 : JPA, Spring Security, JWT 토큰, Mapstruct

 * 실행 방법
mvn clean install 로 mapstruct 에서 자동으로 mapperImpl 을 만들도록 하고 ApiApplication 을 시작해야 합니다.

 * 문제 해결 방법
1. Spring Security 를 사용하여 권한이 없는 사용자의 경우에는 특정 API 에 대한 접근을 차단했습니다. 이 때 JWT Token 으로 filter 설정을 했습니다.
2. 모든 entity 에 필요한 시간 관련된 컬럼은 추상 클래스 Base 를 사용했습니다. Base 클래스에는 createdAt (작성시간), updatedAt (수정시간) 이 있습니다.
   creator (작성자) 에 대한 정보도 추가하고 싶었으나 고객의 경우 로그인을 하지 않기 때문에 만들지 않았습니다.
3. entity 와 dto 맵핑을 위해 mapstruct 를 사용했습니다. 요청을 받을 때와 응답을 줄 때마다 코드로 Entity 를 DTO 에 맞게끔 맵핑하는 것은 너무 비효율적이라 생각하여 사용했습니다.
4. 여러 객체들을 가져와서 사용할 경우에는 Service 가 아닌 Adapter 를 만들어 사용했습니다. Service 단에는 해당 Service 에서 사용하는 Repository 만 사용하고 싶었습니다.
5. VOC 의 답변 상태의 경우, VocStatus 를 update 하는 방식으로 관리했습니다. @Transactional 을 사용했고 isolation level 은 REPEATABLE READ 를 사용했습니다.
   Phantom Read 는 발생할 수 있지만 성능 이슈를 생각해서 REPEATABLE_READ 를 선택했습니다.