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
5. GitHub Actions Workflow 파일
   1. `.github/workflows` 디렉토리 생성
   2. 해당 디렉토리 내에 `hello.yaml` 생성