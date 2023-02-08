package com.powernode.bank.service;

import com.powernode.bank.dao.AccouontDao;
import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author iyeee
 * @Date 2023/2/8 18:14
 * @Version 1.0.1
 */
public class AccountServiceImpl implements AccountService{
    // private AccouontDao accountDao=new AccountDaoImpl();

    // 在mybatis中，mybatis提供了相关的机制，也可以动态生成dao接口的实现类，（代理类，dao接口的代理）
    // 前提是：SqlMapper.xml 文件中namespace必须是dao接口的全限定名称，id必须是dao接口的方法名
    private AccouontDao accountDao=SqlSessionUtil.openSession().getMapper(AccouontDao.class);
    @Override
    public void transfer(String fromActno, String toaActno, double money) throws MoneyNotEnoughException, TransferException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account fromAct=accountDao.selectByActno(fromActno);
        if(fromAct.getBalance()<money){
            throw new MoneyNotEnoughException("对不起，余额不足");
        }
        Account toAct = accountDao.selectByActno(toaActno);
        fromAct.setBalance(fromAct.getBalance()+money);
        toAct.setBalance(toAct.getBalance()-money);
        int i = accountDao.updateByActno(fromAct);
        int i1 = accountDao.updateByActno(toAct);
        // String s=null;
        // s.toString();
        if(i1+i!=2){
            throw new TransferException("转账异常");
        }
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);


    }
}
