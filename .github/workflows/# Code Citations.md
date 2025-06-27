# Code Citations

## License: unknown
https://github.com/lakshmithati/vprofile/tree/f1c85a3017f873d615f583cc6c6e881e7c996c99/.github/workflows/main.yml

```
:
  build:

    runs-on: ubuntu-latest

    steps:
    - name: Checkout repository
      uses: actions/checkout@v2

    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'adopt'

    -
```


## License: unknown
https://github.com/apache/synapse/tree/20112290f1583bb91514ea7a2c4eaa8b14aeaec7/.github/workflows/build_cron.yml

```
/cache@v2
      with:
        path: ~/.m2/repository
        key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
        restore-keys: |
          ${{ runner.os }
```


## License: LGPL_3_0
https://github.com/find-sec-bugs/find-sec-bugs/tree/68628d313f4ed105da5145c7b7289480c469c715/.github/workflows/spotbugs.yml

```
key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
        restore-keys: |
          ${{ runner.os }}-maven-

    - name: Build with Maven
      run: mvn clean
```


## License: Apache_2_0
https://github.com/opencb/java-common-libs/tree/314038f6b5de5d156e3855564230ae77443c4391/.github/workflows/java-build-workflow.yml

```
'

    - name: Cache Maven packages
      uses: actions/cache@v2
      with:
        path: ~/.m2/repository
        key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
        restore-
```


## License: unknown
https://github.com/Yeggstry/microservice-rest-petstore/tree/168070b3f053300f1586e7930ff68e8fce3c8d5e/.github/workflows/ci-cd.yml

```
version: '11'
        distribution: 'adopt'

    - name: Cache Maven packages
      uses: actions/cache@v2
      with:
        path: ~/.m2/repository
        key: ${{ runner.os }}-maven-${{ hashFiles('**/
```

