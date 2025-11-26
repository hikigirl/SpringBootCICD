# CI/CD

### 파일 생성하기
- com.test.team.controller
  - MainController.java
- templates
  - index.html

---
### CI/CD란...
- Continuous Integration
- Continuous Delivery/Deployment
- 로컬(개발) → 커밋 → GitHub(저장소) → DockerHub(이미지) → AWS EC2(배포+실행)

1. 로컬(개발)
2. 프로젝트 -> GitHub 연결하기
   1. 협업 목적
   2. 지속적인 통합/배포(CI/CD)
3. Docker -> 현재 프로젝트를 컨테이너 이미지로 만들기
   1. 프로젝트 루트에 Dockerfile 생성
4. GitHub Actions
   1. 저장소에 push가 발생되면 미리 준비한 행동을 실행하는 도구
5. GitHub Actions Workflow 파일 생성 ~ DockerHub 업로드
   1. `.github/workflows` 디렉토리 생성
   2. 해당 디렉토리 내에 `hello.yaml` 생성(테스트용)
   3. 프로젝트용 Workflow 파일 생성(`ci-cd.yaml`)
   4. push 발생 -> 해당 브랜치(main) checkout -> 소스 읽기 -> JDK 구축 -> Gradle 빌드 -> *.jar -> Dockerfile -> 컨테이너 이미지 생성 -> 도커허브에 업로드
   5. 도커에서 토큰 생성 및 GitHub Actions Secret 등록<br>
      ![도커 토큰 생성](images/01_create_docker_token.png) <br>
      ![GitHub Action Secret 생성](images/02_create_github_secrets.png)
   6. GitHub에 push하면 도커 이미지까지 생성이 완료되고, DockerHub-Repositories에서 확인할 수 있다.
6. 도커허브의 이미지를 다운로드 + 실행
   ```bash
   $ docker image pull hikigirl/team
   $ docker run -d --name team -p 8080:8080 hikigirl/team
   $ docker ps
   ```
7. CD 구현하기
   1. 도커허브 이미지 -> EC2에서 내려받기 -> 컨테이너 실행
   2. GitHub Actions secrets 등록