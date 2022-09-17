pipeline
    {
        agent any
        stages
        {
            stage ('Build')
            {
                steps
                {
                    echo "building the code..........."
                    bat "mvn clean"
                }
            }
            stage ('Test')
            {
                steps
                {
                    echo "testing the code..............."
                    bat "mvn test"
                }
            }
            stage ('Compile')
            {
                steps
                {
                    echo "compiling the project.............."
                    bat "mvn compile"
                }
            }
            stage ('Deploy')
            {
                steps
                {
                    echo "compiling the project..............."
                }
            }
        }
    }

