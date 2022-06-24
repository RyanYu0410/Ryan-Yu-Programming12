<?php
include_once 'header.php';
include_once 'includes/database.php';
?>
    <section class="main-container">
        <div class="main-wrapper">
            <h2>Home Page</h2>
            <?php
            if (isset($_SESSION['u_uid'])) {
                $sql = "SELECT post_id, title, content,timedate,user_uid FROM posts";
                $result = mysqli_query($conn, $sql);
                if (mysqli_num_rows($result) > 0) {
                    while ($row = mysqli_fetch_assoc($result)) {
                        echo '
            <div class="index-info">
                <div class="post-container">
                    <div class="post-innerContainer">
                        <h4 class="post-title">
                            ' . $row["title"] . '
                        </h4>
                        <p class="post-content">
                            ' . $row["content"] . '
                            <br>
                        </p>
                        <div class="post-direct">
                            >See full content here
                            <p class="post-user">
                            ' . $row["user_uid"] . '
                            </p>
                        </div>
                    </div>
                    <div class="post-time">
                        ' . $row["timedate"] . '
                    </div>
                </div>
            </div>';
                    }
                } else {
                    echo "0 结果";
                }
            }
            ?>
            <div class="index-info">
                <div class="post-container">
                    <div class="post-innerContainer">
                        <h4 class="post-title">
                            It's nice to meet you
                        </h4>
                        <p class="post-content">
                            Please go to "signup" to see all the contents
                            <br>
                        </p>
                        <div class="post-direct">
                            >See full content here
                            <p class="post-user">User name</p>
                        </div>
                    </div>
                    <div class="post-time">
                        PST 000nbfs
                    </div>
                </div>
            </div>
        </div>
    </section>
<?php
include_once 'footer.php';
?>