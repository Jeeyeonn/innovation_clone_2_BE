package com.innovation.innovation_clone_be.mail.Service;

import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MailScheduler {

    private final JavaMailSender javaMailSender;
    private static final String FROM_ADDRESS = "osullocclone@gmail.com";
    private final MemberRepository memberRepository;

    @Transactional
    @Scheduled(cron = "0 50 18 * * *")
    public void sendNewsEmail() {
        List<Member> memberList = memberRepository.findAllBySubscriptionEquals(true);
        for (Member member: memberList) {
            sendEMail(member.getEmail());
        }
        System.out.println("실행");
    }

    public void sendEMail (String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_ADDRESS);
        message.setTo(email);
        message.setSubject("오설록 구독 메일입니다.");
        message.setText("이번 주 오설록 구독 서비스입니다.\n 사이트 오셔서 구경해보세요~\n https://www.osulloc.com/kr/ko");

        javaMailSender.send(message);
    }

}
